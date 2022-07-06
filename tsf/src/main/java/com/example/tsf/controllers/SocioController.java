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

import com.example.tsf.entity.PenaDto;
import com.example.tsf.entity.SocioDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.services.interfaces.ISocio;

@RestController
@RequestMapping("/api/socio")
public class SocioController {

	@Autowired
	private ISocio service;
	private static final Log LOG = LogFactory.getLog(SocioController.class);
    
    @GetMapping("/{id}")
    public SocioDto get(
            @PathVariable("id") Long id){
        LOG.info("getSocio con id: "+id);
        return service.get(id);
    }

    @GetMapping
    public List<SocioDto> getAll(){
        LOG.info("getAllSocioDto");
        return service.getAll();
    }

    @PostMapping
    public SocioDto save(@RequestBody SocioDto itemDto){
        LOG.info("Guardando Socio: "+ itemDto.toString());
        return service.add(itemDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public SocioDto update(@RequestBody SocioDto itemDto){
        LOG.info("Actualizando Socio: "+ itemDto);
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
        LOG.info("Borrando Peña: "+id);
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
