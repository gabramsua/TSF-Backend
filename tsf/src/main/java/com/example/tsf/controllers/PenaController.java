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
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.services.interfaces.IPena;

@RestController
@RequestMapping("/api/pena")
public class PenaController {

	@Autowired
	private IPena service;
	private static final Log LOG = LogFactory.getLog(PenaController.class);

	@GetMapping("/hola")
    public String get(){
//        LOG.info("getPeña con id: "+id);
        return "HOLA MUNDO!!!";
    }

    
    @GetMapping("/{id}")
    public PenaDto get(
            @PathVariable("id") Long id){
        LOG.info("getPeña con id: "+id);
        return service.get(id);
    }

    @GetMapping
    public List<PenaDto> getAll(){
        LOG.info("getAllPeñas");
        return service.getAll();
    }

    @PostMapping
    public PenaDto save(@RequestBody PenaDto penaDto){
        LOG.info("Guardando Peña: "+ penaDto.toString());
        return service.add(penaDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public PenaDto updateGrupo(@RequestBody PenaDto penaDto){
        LOG.info("Actualizando Peña: "+ penaDto);
        try {
        	return service.update(penaDto);
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
