package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.CompeticionDto;
import com.example.tsf.entity.PancartaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.CompeticionRepository;
import com.example.tsf.services.interfaces.ICompeticion;

@Service
public class CompeticionImpl implements ICompeticion{


	private static final Log LOG = LogFactory.getLog(CompeticionImpl.class);

	@Autowired
	private CompeticionRepository itemRepository;
	
	private String entity="Competicion", field="nombre";
	

    @Override
    public CompeticionDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
        	CompeticionDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<CompeticionDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public CompeticionDto add(CompeticionDto itemDto) {
    	CompeticionDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public CompeticionDto update(CompeticionDto itemDto) {
        LOG.info("update "+entity+itemDto.getNombre());
        try{
        	CompeticionDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getNombre()));
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
        	CompeticionDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
