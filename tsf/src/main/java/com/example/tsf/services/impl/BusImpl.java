package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.BusDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.BusRepository;
import com.example.tsf.services.interfaces.IBus;

@Service
public class BusImpl  implements IBus{


	private static final Log LOG = LogFactory.getLog(BusImpl.class);

	@Autowired
	private BusRepository itemRepository;
	
	private String entity="Bus", field="id";
	

    @Override
    public BusDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            BusDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<BusDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public BusDto add(BusDto itemDto) {
    	BusDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public BusDto update(BusDto itemDto) {
        LOG.info("update "+entity +itemDto);
        try{
        	BusDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	BusDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
