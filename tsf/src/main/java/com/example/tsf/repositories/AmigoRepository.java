package com.example.tsf.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tsf.entity.AmigoDto;
@Repository
public interface AmigoRepository extends JpaRepository<AmigoDto, Serializable>{

}
