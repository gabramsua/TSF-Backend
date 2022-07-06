package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.PublicoDto;

public interface IPublico {

	public abstract PublicoDto get(Long id);
    public abstract List<PublicoDto> getAll();
    public abstract PublicoDto add(PublicoDto itemDto);
    public abstract PublicoDto update(PublicoDto itemDto);
    public abstract Boolean remove(Long id);
}
