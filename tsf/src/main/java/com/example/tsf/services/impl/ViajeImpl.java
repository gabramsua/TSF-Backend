package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.ViajeDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.ViajeRepository;
import com.example.tsf.services.interfaces.IViaje;

@Service
public class ViajeImpl implements IViaje{

	private static final Log LOG = LogFactory.getLog(ViajeImpl.class);

	@Autowired
	private ViajeRepository itemRepository;
	
	private String entity="Viaje", field="id";
	

    @Override
    public ViajeDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            ViajeDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<ViajeDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public ViajeDto add(ViajeDto itemDto) {
    	ViajeDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public ViajeDto update(ViajeDto itemDto) {
        LOG.info("update "+entity+itemDto.getId());
        try{
        	ViajeDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	ViajeDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
