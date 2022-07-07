package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.EquipoDto;

public interface IEquipo {

	public abstract EquipoDto get(Long id);
    public abstract List<EquipoDto> getAll();
    public abstract EquipoDto add(EquipoDto itemDto);
    public abstract EquipoDto update(EquipoDto itemDto);
    public abstract Boolean remove(Long id);
}
