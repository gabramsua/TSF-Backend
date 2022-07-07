package com.example.tsf.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tsf.entity.ActividadDto;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadDto, Serializable>{

}
