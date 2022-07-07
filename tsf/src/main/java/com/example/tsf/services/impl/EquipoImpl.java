package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.EquipoDto;
import com.example.tsf.entity.PancartaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.EquipoRepository;
import com.example.tsf.services.interfaces.IEquipo;

@Service
public class EquipoImpl implements IEquipo{


	private static final Log LOG = LogFactory.getLog(PancartaImpl.class);

	@Autowired
	private EquipoRepository itemRepository;
	
	private String entity="Equipo", field="id";
	

    @Override
    public EquipoDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
        	EquipoDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<EquipoDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public EquipoDto add(EquipoDto itemDto) {
    	EquipoDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public EquipoDto update(EquipoDto itemDto) {
        LOG.info("update "+entity+itemDto.getNombre());
        try{
        	EquipoDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	EquipoDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
