package com.example.tsf.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tsf.controllers.PenaController;
import com.example.tsf.entity.PenaDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.repositories.PenaRepository;
import com.example.tsf.services.interfaces.IPena;

@Service
public class PenaImpl implements IPena{
	private static final Log LOG = LogFactory.getLog(PenaImpl.class);

	@Autowired
	private PenaRepository itemRepository;
	

    @Override
    public PenaDto get(Long id) {
        if(id <= 0) { throw new IllegalArgumentException("El id no puede ser negativo");}

        try {
            Optional<PenaDto> item = itemRepository.findById(id);
            if (item.isPresent()) {
                return item.get();
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }
        return null;
    }

    @Override
    public List<PenaDto> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public PenaDto add(PenaDto itemDto) {

        // Comprobar que el usuario existe
//        loginService.checkIfExists(grupoDto.getIdCreador());
//         Comprobar que no existe un grupo con el mismo creador y nombre
//        checkIfGrupoExistsWhenCreate(grupoDto);

        PenaDto res = itemRepository.save(itemDto);

        // Meter al creador en UsuarioGrupo
//        UsuarioPenaDto ug = new UsuarioPenaDto(null, Boolean.TRUE, res.getId(), res.getIdCreador());
//        usuarioGrupoService.add(ug);

        return res;
    }

    @Override
    public PenaDto update(PenaDto itemDto) {
        LOG.info("updatePeñaService");
        try{
        	PenaDto res = itemRepository.findByCif(itemDto.getCif()).orElseThrow(() -> new ResourceNotFoundException("Peña", "cif", itemDto.getCif()));
        	itemDto.setId(res.getId());
        	return itemRepository.save(itemDto);
        } catch (NullPointerException e){
            throw new NullPointerException("El id del grupo no existe");
        } catch (Exception e) {
        	LOG.info(e.getMessage());
        	throw new IllegalArgumentException(e.toString());
        }
//        return null;
    }

    @Override
    public Boolean remove(Long id) {
        try{
//        	get(id);
            PenaDto item =	itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Peña", "id", id)); 
            if(!item.equals(null)){
//                usuarioGrupoService.removeAllFromGrupo(id);
                itemRepository.delete(item);
                return Boolean.TRUE;
            }
        }catch (NullPointerException e){
            throw new NullPointerException("El id del elemento no existe");
        }
        return Boolean.FALSE;
    }

//    public PenaDto checkIfExists (Long id, String entity){
//        return itemRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException(entity, "id", id));
//    }
}
