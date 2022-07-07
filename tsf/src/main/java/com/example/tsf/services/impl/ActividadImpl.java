package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.ActividadDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.ActividadRepository;
import com.example.tsf.services.interfaces.IActividad;

@Service
public class ActividadImpl implements IActividad{

	private static final Log LOG = LogFactory.getLog(ActividadImpl.class);

	@Autowired
	private ActividadRepository itemRepository;
	
	private String entity="Actividad", field="id";
	

    @Override
    public ActividadDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            ActividadDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<ActividadDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public ActividadDto add(ActividadDto itemDto) {
    	ActividadDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public ActividadDto update(ActividadDto itemDto) {
        LOG.info("update "+entity+itemDto.getNombre());
        try{
        	ActividadDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	ActividadDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
