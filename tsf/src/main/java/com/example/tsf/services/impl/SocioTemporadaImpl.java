package com.example.tsf.services.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.SocioTemporadaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.SocioTemporadaRepository;
import com.example.tsf.services.interfaces.ISocioTemporada;

@Service
public class SocioTemporadaImpl implements ISocioTemporada{

	private static final Log LOG = LogFactory.getLog(SocioTemporadaImpl.class);

	@Autowired
	private SocioTemporadaRepository itemRepository;
	
	private String entity="SocioTemporada", field="id";
	

    @Override
    public SocioTemporadaDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
        	SocioTemporadaDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<SocioTemporadaDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public SocioTemporadaDto add(SocioTemporadaDto itemDto) {
    	SocioTemporadaDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public SocioTemporadaDto update(SocioTemporadaDto itemDto) {
        LOG.info("update "+entity+itemDto.getTemporada());
        try{
        	SocioTemporadaDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	SocioTemporadaDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
            if(!item.equals(null)){
                itemRepository.delete(item);
                return Boolean.TRUE;
            }
        }catch (NullPointerException e){
            throw new NullPointerException("El id del elemento no existe");
        }
        return Boolean.FALSE;
    }

    public SocioTemporadaDto pagar(Long id, String metodoPago ) {
    	SocioTemporadaDto aux = get(id);

    	aux.setIscuotapagada(true);
    	aux.setMetodopago(metodoPago);
        aux.setFecha(calculateCurrentTimestamp());
    	
    	// TODO: insertar elemento en tesoreria
    	return itemRepository.save(aux);
    }
	public Timestamp calculateCurrentTimestamp() {
    	Calendar calendar = Calendar.getInstance();
        calendar.getTimeInMillis();
        // TODO: REVISAR ESTO EH
//        calendar.add(Calendar.HOUR, 2);
        return new Timestamp(calendar.getTimeInMillis());
	}
    

}
