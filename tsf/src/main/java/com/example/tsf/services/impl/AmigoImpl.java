package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.AmigoDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.AmigoRepository;
import com.example.tsf.services.interfaces.IAmigo;

import Utils.Helpers;

@Service
public class AmigoImpl implements IAmigo{


	private static final Log LOG = LogFactory.getLog(AmigoImpl.class);

	@Autowired
	private AmigoRepository itemRepository;
	
	private String entity="Amigo", field="id";
	

    @Override
    public AmigoDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            AmigoDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<AmigoDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public AmigoDto add(AmigoDto itemDto) {
    	itemDto.setFecha(Helpers.calculateCurrentTimestamp());
    	AmigoDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public AmigoDto update(AmigoDto itemDto) {
        LOG.info("update "+entity+itemDto);
        try{
        	AmigoDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	AmigoDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
