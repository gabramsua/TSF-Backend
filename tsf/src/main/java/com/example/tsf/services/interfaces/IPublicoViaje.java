package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.PublicoViajeDto;

public interface IPublicoViaje {
	public abstract PublicoViajeDto get(Long id);
    public abstract List<PublicoViajeDto> getAll();
    public abstract PublicoViajeDto add(PublicoViajeDto itemDto);
    public abstract PublicoViajeDto update(PublicoViajeDto itemDto);
    public abstract Boolean remove(Long id);

}
