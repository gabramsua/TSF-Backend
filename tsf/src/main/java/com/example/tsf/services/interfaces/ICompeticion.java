package com.example.tsf.services.interfaces;

import java.util.List;

import com.example.tsf.entity.CompeticionDto;

public interface ICompeticion {

	public abstract CompeticionDto get(Long id);
    public abstract List<CompeticionDto> getAll();
    public abstract CompeticionDto add(CompeticionDto itemDto);
    public abstract CompeticionDto update(CompeticionDto itemDto);
    public abstract Boolean remove(Long id);
}
