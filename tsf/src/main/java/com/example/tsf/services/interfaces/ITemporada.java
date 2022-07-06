package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.TemporadaDto;

public interface ITemporada {

	public abstract TemporadaDto get(Long id);
    public abstract List<TemporadaDto> getAll();
    public abstract TemporadaDto add(TemporadaDto itemDto);
    public abstract TemporadaDto update(TemporadaDto itemDto);
    public abstract Boolean remove(Long id);
}
