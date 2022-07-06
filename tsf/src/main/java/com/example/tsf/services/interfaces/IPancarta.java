package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.PancartaDto;

public interface IPancarta {

	public abstract PancartaDto get(Long id);
    public abstract List<PancartaDto> getAll();
    public abstract PancartaDto add(PancartaDto itemDto);
    public abstract PancartaDto update(PancartaDto itemDto);
    public abstract Boolean remove(Long id);

}
