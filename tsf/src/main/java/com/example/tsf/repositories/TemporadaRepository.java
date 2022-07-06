package com.example.tsf.repositories;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tsf.entity.FotoDto;
import com.example.tsf.entity.TemporadaDto;

public interface TemporadaRepository extends JpaRepository<TemporadaDto, Serializable> {
	List<TemporadaDto> findByIdIn(List<Long> ids);
	Optional<TemporadaDto> findByNombre(String nombre);
	

  @Query(value="SELECT * FROM Temporada t ORDER BY f.id DESC LIMIT 1 ",
			  nativeQuery = true)
  	TemporadaDto findCurrentTemporada();

}
