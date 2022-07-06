package com.example.tsf.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.TemporadaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.TemporadaRepository;
import com.example.tsf.services.interfaces.ITemporada;

@Service
public class TemporadaImpl implements ITemporada {


	private static final Log LOG = LogFactory.getLog(SocioImpl.class);

	@Autowired
	private TemporadaRepository itemRepository;
	
	private String entity="Temporada", field="id";
	

    @Override
    public TemporadaDto get(Long id) {
        if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            Optional<TemporadaDto> item = itemRepository.findById(id);
            if (item.isPresent()) {
                return item.get();
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        return null;
    }

    @Override
    public List<TemporadaDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public TemporadaDto add(TemporadaDto itemDto) {
    	TemporadaDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public TemporadaDto update(TemporadaDto itemDto) {
        LOG.info("updateSocioService");
        try{
        	TemporadaDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	TemporadaDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
