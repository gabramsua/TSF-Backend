package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.AmigoDto;

public interface IAmigo {

	public abstract AmigoDto get(Long id);
    public abstract List<AmigoDto> getAll();
    public abstract AmigoDto add(AmigoDto itemDto);
    public abstract AmigoDto update(AmigoDto itemDto);
    public abstract Boolean remove(Long id);
}
