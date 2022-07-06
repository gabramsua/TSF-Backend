package com.example.tsf.services.interfaces;

import java.sql.Timestamp;
import java.util.List;

import com.example.tsf.entity.FotoDto;

public interface IFoto {

	public abstract FotoDto get(Long id);
    public abstract List<FotoDto> getAll();
    public abstract FotoDto add(FotoDto itemDto);
    public abstract FotoDto update(FotoDto itemDto);
    public abstract Boolean remove(Long id);
    
    public abstract List<FotoDto>getAllBetween(Timestamp date1, Timestamp date2);

}
