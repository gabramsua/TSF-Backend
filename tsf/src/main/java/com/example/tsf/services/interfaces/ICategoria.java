package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.CategoriaDto;

public interface ICategoria {
	public abstract CategoriaDto get(Long id);
    public abstract List<CategoriaDto> getAll();
    public abstract CategoriaDto add(CategoriaDto itemDto);
    public abstract CategoriaDto update(CategoriaDto itemDto);
    public abstract Boolean remove(Long id);
}
