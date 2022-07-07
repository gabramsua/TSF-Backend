package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.ActividadSocioDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.ActividadSocioRepository;
import com.example.tsf.services.interfaces.IActividadSocio;

@Service
public class ActividadSocioImpl implements IActividadSocio {


	private static final Log LOG = LogFactory.getLog(ActividadSocioImpl.class);

	@Autowired
	private ActividadSocioRepository itemRepository;
	
	private String entity="ActividadSocio", field="id";
	

    @Override
    public ActividadSocioDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            ActividadSocioDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<ActividadSocioDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public ActividadSocioDto add(ActividadSocioDto itemDto) {
    	ActividadSocioDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public ActividadSocioDto update(ActividadSocioDto itemDto) {
        LOG.info("update "+entity+itemDto);
        try{
        	ActividadSocioDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
        	itemDto.setId(res.getId());
        	return itemRepository.save(itemDto);
        } catch (NullPointerException e){
            throw new NullPointerException("El id del grupo no existe");
        } catch (Exception e) {
        	LOG.info(e.getMessage());
        	throw new IllegalArgumentException(e.toString());
        }
    }

    @Override
    public Boolean remove(Long id) {
        try{
//        	get(id);
        	ActividadSocioDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
            if(!item.equals(null)){
                itemRepository.delete(item);
                return Boolean.TRUE;
            }
        }catch (NullPointerException e){
            throw new NullPointerException("El id del elemento no existe");
        }
        return Boolean.FALSE;
    }
}
