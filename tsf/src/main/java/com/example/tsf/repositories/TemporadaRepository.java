package com.example.tsf.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tsf.entity.TemporadaDto;

public interface TemporadaRepository extends JpaRepository<TemporadaDto, Serializable> {
	List<TemporadaDto> findByIdIn(List<Long>ids);
	Optional<TemporadaDto> findByNombre(String nombre);
}
