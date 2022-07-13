package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.CargoJuntaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.CargoJuntaRepository;
import com.example.tsf.services.interfaces.ICargoJunta;

@Service
public class CargoJuntaImpl implements ICargoJunta{

	private static final Log LOG = LogFactory.getLog(CargoJuntaImpl.class);

	@Autowired
	private CargoJuntaRepository itemRepository;
	
	private String entity="CargoJunta", field="nombre";

    @Override
    public CargoJuntaDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
        	CargoJuntaDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<CargoJuntaDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public CargoJuntaDto add(CargoJuntaDto itemDto) {
    	CargoJuntaDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public CargoJuntaDto update(CargoJuntaDto itemDto) {
        LOG.info("update "+entity+itemDto.getPuesto());
        try{
        	CargoJuntaDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getPuesto()));
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
        	CargoJuntaDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
