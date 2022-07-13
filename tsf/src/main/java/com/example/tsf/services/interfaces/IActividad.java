package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.ActividadDto;

public interface IActividad {

	public abstract ActividadDto get(Long id);
    public abstract List<ActividadDto> getAll();
    public abstract ActividadDto add(ActividadDto itemDto);
    public abstract ActividadDto update(ActividadDto itemDto);
    public abstract Boolean remove(Long id);
}
