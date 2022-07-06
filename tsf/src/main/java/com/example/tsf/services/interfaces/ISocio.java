package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.SocioDto;

public interface ISocio {
	public abstract SocioDto get(Long id);
    public abstract List<SocioDto> getAll();
    public abstract SocioDto add(SocioDto itemDto);
    public abstract SocioDto update(SocioDto itemDto);
    public abstract Boolean remove(Long id);

}
