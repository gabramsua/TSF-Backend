package com.example.tsf.services.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.SocioDto;
import com.example.tsf.entity.SocioTemporadaDto;
import com.example.tsf.entity.TemporadaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.SocioRepository;
import com.example.tsf.repositories.SocioTemporadaRepository;
import com.example.tsf.repositories.TemporadaRepository;
import com.example.tsf.services.interfaces.ISocio;

import enums.MetodoPago;

@Service
public class SocioImpl implements ISocio {

	private static final Log LOG = LogFactory.getLog(SocioImpl.class);

	@Autowired
	private SocioRepository itemRepository;
	@Autowired
	private SocioTemporadaRepository socioTemporadaRepository;
	@Autowired
	private TemporadaRepository temporadaRepository;
	

    @Override
    public SocioDto get(Long id) {
        if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            Optional<SocioDto> item = itemRepository.findById(id);
            if (item.isPresent()) {
                return item.get();
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        return null;
    }

    @Override
    public List<SocioDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public SocioDto add(SocioDto itemDto) {
    	SocioDto res = itemRepository.save(itemDto);

    	// Alta o Renovación => insertar en SocioTemporada
    	SocioTemporadaDto aux = new SocioTemporadaDto();
    	aux.setSocio(res);
    	TemporadaDto t = temporadaRepository.findCurrentTemporada();
    	aux.setTemporada(t);
    	
    	socioTemporadaRepository.save(aux);
    	
    	
        return (res != null && aux != null) ? res : null;
    }

    @Override
    public SocioDto update(SocioDto itemDto) {
        LOG.info("updateSocioService");
        try{
        	SocioDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Socio", "id", itemDto.getId()));
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
        	SocioDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Socio", "id", id)); 
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
