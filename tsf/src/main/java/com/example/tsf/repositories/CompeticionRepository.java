package com.example.tsf.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tsf.entity.CompeticionDto;

public interface CompeticionRepository extends JpaRepository<CompeticionDto, Serializable>{
	
}
