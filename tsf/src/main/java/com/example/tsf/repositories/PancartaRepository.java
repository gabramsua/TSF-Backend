package com.example.tsf.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tsf.entity.PancartaDto;
import com.example.tsf.entity.TemporadaDto;

@Repository
public interface PancartaRepository extends JpaRepository<PancartaDto, Serializable>{

	List<TemporadaDto> findByIdIn(List<Long>ids);
}
