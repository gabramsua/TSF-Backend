package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.CargoJuntaDto;

public interface ICargoJunta {
	public abstract CargoJuntaDto get(Long id);
    public abstract List<CargoJuntaDto> getAll();
    public abstract CargoJuntaDto add(CargoJuntaDto itemDto);
    public abstract CargoJuntaDto update(CargoJuntaDto itemDto);
    public abstract Boolean remove(Long id);
}
