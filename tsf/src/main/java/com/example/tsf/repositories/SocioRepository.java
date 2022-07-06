package com.example.tsf.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tsf.entity.SocioDto;

public interface SocioRepository extends JpaRepository<SocioDto, Serializable> {

    List<SocioDto> findByIdIn(List<Long> ids);
    Optional<SocioDto> findByDni(String dni);
}
