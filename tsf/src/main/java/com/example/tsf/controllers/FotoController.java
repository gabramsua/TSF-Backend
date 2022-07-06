package com.example.tsf.controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
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

import com.example.tsf.entity.FotoDto;
import com.example.tsf.exception.ResourceNotFoundException;
import com.example.tsf.services.interfaces.IFoto;

@RestController
@RequestMapping("/api/foto")
public class FotoController {

	@Autowired
	private IFoto service;
	private static final Log LOG = LogFactory.getLog(FotoController.class);
	
	private String entity = "Foto";
    
    @GetMapping("/{id}")
    public FotoDto get(
            @PathVariable("id") Long id){
        LOG.info("Get "+entity+" con id: "+id);
        return service.get(id);
    }

    @GetMapping
    public List<FotoDto> getAll(){
        LOG.info("getAll "+entity);
        return service.getAll();
    }

    @PostMapping
    public FotoDto save(@RequestBody FotoDto itemDto){
        LOG.info("Guardando "+entity+": "+itemDto.toString());
        return service.add(itemDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public FotoDto update(@RequestBody FotoDto itemDto){
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

    @SuppressWarnings("deprecation")
	@GetMapping("/{date1}/{date2}")
    public List<FotoDto> getFotosBetweenDates(@PathVariable("date1") String date1, @PathVariable("date2") String date2){
        LocalDate date_1 = LocalDate.parse(date1);
        LocalDate date_2 = LocalDate.parse(date2);
        Timestamp t1_date = new Timestamp(date_1.getYear()-1900, date_1.getMonthValue()-1, date_1.getDayOfMonth(), 0, 0, 0, 0);
        Timestamp t2_date = new Timestamp(date_2.getYear()-1900, date_2.getMonthValue()-1, date_2.getDayOfMonth(), 23, 59, 59, 999);
        LOG.info("Get "+entity+" between dates: >= "+t1_date+" <= "+t2_date);
        return service.getAllBetween(t1_date, t2_date);
    }

}
