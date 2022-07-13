package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.tsf.entity.SocioBanderaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.SocioBanderaRepository;
import com.example.tsf.services.interfaces.ISocioBandera;

@Repository
public class SocioBanderaImpl implements ISocioBandera{


	private static final Log LOG = LogFactory.getLog(SocioBanderaImpl.class);

	@Autowired
	private SocioBanderaRepository itemRepository;
	
	private String entity="SocioBandera", field="id";
	

    @Override
    public SocioBanderaDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            SocioBanderaDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<SocioBanderaDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public SocioBanderaDto add(SocioBanderaDto itemDto) {
    	SocioBanderaDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public SocioBanderaDto update(SocioBanderaDto itemDto) {
        LOG.info("update "+entity+itemDto);
        try{
        	SocioBanderaDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	SocioBanderaDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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