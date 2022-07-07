package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.SocioViajeDto;

public interface ISocioViaje {
	public abstract SocioViajeDto get(Long id);
    public abstract List<SocioViajeDto> getAll();
    public abstract SocioViajeDto add(SocioViajeDto itemDto);
    public abstract SocioViajeDto update(SocioViajeDto itemDto);
    public abstract Boolean remove(Long id);

}
