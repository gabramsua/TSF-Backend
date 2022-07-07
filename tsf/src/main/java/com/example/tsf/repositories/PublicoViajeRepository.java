package com.example.tsf.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tsf.entity.PublicoViajeDto;

public interface PublicoViajeRepository extends JpaRepository<PublicoViajeDto, Serializable> {

}
