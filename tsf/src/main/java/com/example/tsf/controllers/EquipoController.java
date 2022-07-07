package com.example.tsf.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.tsf.entity.EquipoDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.services.interfaces.IEquipo;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {


	@Autowired
	private IEquipo service;
	private static final Log LOG = LogFactory.getLog(EquipoController.class);
	
	private String entity = "Equipo";
    
    @GetMapping("/{id}")
    public EquipoDto get(
            @PathVariable("id") Long id){
        LOG.info("Get "+entity+" con id: "+id);
        return service.get(id);
    }

    @GetMapping
    public List<EquipoDto> getAll(){
        LOG.info("getAll"+entity);
        return service.getAll();
    }

    @PostMapping
    public EquipoDto save(@RequestBody EquipoDto itemDto){
        LOG.info("Guardando "+entity+": "+itemDto.toString());
        return service.add(itemDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public EquipoDto update(@RequestBody EquipoDto itemDto){
        LOG.info("Actualizando "+entity+": "+itemDto);
        try {
        	return service.update(itemDto);
        } catch(ResourceNotFoundException e) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
        	LOG.info(e.getMessage());
        	throw new IllegalArgumentException(e.toString());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        LOG.info("Borrando"+entity+": "+id);
        try {
        	service.remove(id);
	    } catch(ResourceNotFoundException e) {
	    	LOG.info(e.getMessage());
	    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
	    } catch (Exception e) {
	    	LOG.info(e.getMessage());
	    	throw new IllegalArgumentException(e.toString());
	    }
    }
}
