package com.example.tsf.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.PancartaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.PancartaRepository;
import com.example.tsf.services.interfaces.IPancarta;

@Service
public class PancartaImpl implements IPancarta{

	private static final Log LOG = LogFactory.getLog(PancartaImpl.class);

	@Autowired
	private PancartaRepository itemRepository;
	
	private String entity="Pancarta", field="id";
	

    @Override
    public PancartaDto get(Long id) {
        if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            Optional<PancartaDto> item = itemRepository.findById(id);
            if (item.isPresent()) {
                return item.get();
            }

        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        return null;
    }

    @Override
    public List<PancartaDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public PancartaDto add(PancartaDto itemDto) {
    	PancartaDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public PancartaDto update(PancartaDto itemDto) {
        LOG.info("update "+entity+itemDto.getNombre());
        try{
        	PancartaDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	PancartaDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
