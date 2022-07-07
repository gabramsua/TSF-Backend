package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.SocioViajeDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.SocioViajeRepository;
import com.example.tsf.services.interfaces.ISocioViaje;

import Utils.Helpers;

@Service
public class SocioViajeImpl implements ISocioViaje{

	private static final Log LOG = LogFactory.getLog(SocioViajeImpl.class);

	@Autowired
	private SocioViajeRepository itemRepository;
	public Helpers helpers;
	
	private String entity="SocioViaje", field="id";
	
    @Override
    public SocioViajeDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
        	SocioViajeDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<SocioViajeDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public SocioViajeDto add(SocioViajeDto itemDto) {
    	itemDto.setFecha(helpers.calculateCurrentTimestamp());
    	SocioViajeDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public SocioViajeDto update(SocioViajeDto itemDto) {
        LOG.info("update "+entity+itemDto);
        try{
        	SocioViajeDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	SocioViajeDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
