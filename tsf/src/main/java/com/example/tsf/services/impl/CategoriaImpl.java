package com.example.tsf.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.entity.CategoriaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.CategoriaRepository;
import com.example.tsf.services.interfaces.ICategoria;

@Service
public class CategoriaImpl implements ICategoria {

	private static final Log LOG = LogFactory.getLog(CategoriaImpl.class);

	@Autowired
	private CategoriaRepository itemRepository;
	
	private String entity="Categoria", field="nombre";
	

    @Override
    public CategoriaDto get(Long id) {
    	if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
        	CategoriaDto item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id));
            return item;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public List<CategoriaDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public CategoriaDto add(CategoriaDto itemDto) {
    	CategoriaDto res = itemRepository.save(itemDto);
        return res;
    }

    @Override
    public CategoriaDto update(CategoriaDto itemDto) {
        LOG.info("update "+entity+itemDto.getNombre());
        try{
        	CategoriaDto res = itemRepository.findById(itemDto.getId()).orElseThrow(() -> new ResourceNotFoundException(entity, field, itemDto.getNombre()));
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
        	CategoriaDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(entity, field, id)); 
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
