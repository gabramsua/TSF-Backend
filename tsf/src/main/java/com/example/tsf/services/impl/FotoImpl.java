package com.example.tsf.services.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.FotoDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.FotoRepository;
import com.example.tsf.services.interfaces.IFoto;

@Service
public class FotoImpl implements IFoto {


	private static final Log LOG = LogFactory.getLog(FotoImpl.class);

	@Autowired
	private FotoRepository itemRepository;

	private String entity="Foto", field="id";
	

    @Override
    public FotoDto get(Long id) {
        if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            Optional<FotoDto> item = itemRepository.findById(id);
            if (item.isPresent()) {
                return item.get();
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        return null;
    }

    @Override
    public List<FotoDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public FotoDto add(FotoDto itemDto) {
    	itemDto.setFecha(calculateCurrentTimestamp());
    	FotoDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public FotoDto update(FotoDto itemDto) {
        LOG.info("update "+entity+itemDto.getNombre());
        try{
        	FotoDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getId()));
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
        	FotoDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
            if(!item.equals(null)){
                itemRepository.delete(item);
                return Boolean.TRUE;
            }
        }catch (NullPointerException e){
            throw new NullPointerException("El id del elemento no existe");
        }
        return Boolean.FALSE;
    }

	@Override
	public List<FotoDto> getAllBetween(Timestamp date1, Timestamp date2) {
        return itemRepository.getFotosBetweenDates(date1, date2);
	}
	
	public Timestamp calculateCurrentTimestamp() {
    	Calendar calendar = Calendar.getInstance();
        calendar.getTimeInMillis();
        calendar.add(Calendar.HOUR, 2);
        return new Timestamp(calendar.getTimeInMillis());
	}
}
