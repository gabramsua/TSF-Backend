package com.example.tsf.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tsf.entity.PenaDto;

public interface PenaRepository extends JpaRepository<PenaDto, Serializable> {
    List<PenaDto> findByIdIn(List<Long> ids);
    Optional<PenaDto> findByNombre(String nombre);
    Optional<PenaDto> findByCif(String cif);

}
