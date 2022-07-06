package com.example.tsf.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.PublicoDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.PublicoRepository;
import com.example.tsf.services.interfaces.IPublico;

@Service
public class PublicoImpl implements IPublico{


	private static final Log LOG = LogFactory.getLog(PublicoImpl.class);

	@Autowired
	private PublicoRepository itemRepository;
	
	private String entity="Amigo", field="id";
	

    @Override
    public PublicoDto get(Long id) {
        if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            PublicoDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<PublicoDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public PublicoDto add(PublicoDto itemDto) {
    	PublicoDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public PublicoDto update(PublicoDto itemDto) {
        LOG.info("update "+entity+itemDto.getNombre());
        try{
        	PublicoDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	PublicoDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
