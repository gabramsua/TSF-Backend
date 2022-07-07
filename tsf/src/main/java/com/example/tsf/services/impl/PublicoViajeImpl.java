package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.PublicoViajeDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.PublicoViajeRepository;
import com.example.tsf.services.interfaces.IPublicoViaje;

import Utils.Helpers;

@Service
public class PublicoViajeImpl implements IPublicoViaje{


	private static final Log LOG = LogFactory.getLog(PublicoViajeImpl.class);

	@Autowired
	private PublicoViajeRepository itemRepository;
	public Helpers helpers;
	
	private String entity="PublicoViaje", field="id";
	
    @Override
    public PublicoViajeDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
        	PublicoViajeDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<PublicoViajeDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public PublicoViajeDto add(PublicoViajeDto itemDto) {
    	itemDto.setFecha(helpers.calculateCurrentTimestamp());
    	PublicoViajeDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public PublicoViajeDto update(PublicoViajeDto itemDto) {
        LOG.info("update "+entity+itemDto);
        try{
        	PublicoViajeDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	PublicoViajeDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
