package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.BusDto;

public interface IBus {
	public abstract BusDto get(Long id);
    public abstract List<BusDto> getAll();
    public abstract BusDto add(BusDto itemDto);
    public abstract BusDto update(BusDto itemDto);
    public abstract Boolean remove(Long id);
}
