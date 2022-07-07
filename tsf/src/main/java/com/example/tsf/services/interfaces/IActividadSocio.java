package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.ActividadSocioDto;

public interface IActividadSocio {

	public abstract ActividadSocioDto get(Long id);
    public abstract List<ActividadSocioDto> getAll();
    public abstract ActividadSocioDto add(ActividadSocioDto itemDto);
    public abstract ActividadSocioDto update(ActividadSocioDto itemDto);
    public abstract Boolean remove(Long id);
}
