package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.SocioBanderaDto;

public interface ISocioBandera {
	public abstract SocioBanderaDto get(Long id);
    public abstract List<SocioBanderaDto> getAll();
    public abstract SocioBanderaDto add(SocioBanderaDto itemDto);
    public abstract SocioBanderaDto update(SocioBanderaDto itemDto);
    public abstract Boolean remove(Long id);

}
