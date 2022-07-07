package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.ViajeDto;

public interface IViaje {

	public abstract ViajeDto get(Long id);
    public abstract List<ViajeDto> getAll();
    public abstract ViajeDto add(ViajeDto itemDto);
    public abstract ViajeDto update(ViajeDto itemDto);
    public abstract Boolean remove(Long id);
}
