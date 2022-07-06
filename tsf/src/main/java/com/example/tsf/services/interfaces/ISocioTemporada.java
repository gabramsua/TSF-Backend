package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.SocioTemporadaDto;

public interface ISocioTemporada {
	public abstract SocioTemporadaDto get(Long id);
    public abstract List<SocioTemporadaDto> getAll();
    public abstract SocioTemporadaDto add(SocioTemporadaDto itemDto);
    public abstract SocioTemporadaDto update(SocioTemporadaDto itemDto);
    public abstract Boolean remove(Long id);

}
