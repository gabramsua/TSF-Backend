package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.PenaDto;

public interface IPena {

    public abstract PenaDto get(Long id);
    public abstract List<PenaDto> getAll();
    public abstract PenaDto add(PenaDto penaDto);
    public abstract PenaDto update(PenaDto penaDto);
    public abstract Boolean remove(Long id);
}
