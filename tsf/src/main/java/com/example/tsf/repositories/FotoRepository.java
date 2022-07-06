package com.example.tsf.repositories;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tsf.entity.FotoDto;

@Repository
public interface FotoRepository extends JpaRepository<FotoDto, Serializable> {
	List<FotoDto> findByIdIn(List<Long>ids);
	Optional<FotoDto> findByNombre(String nombre);
	/**
	   * Find the pictures uploaded between two dates.
	   *
	   * @param lower date1
	   * @param upper date2
	   * @return the list of photos
	   */
	  @Query(value="SELECT * FROM Foto f WHERE f.fecha >= :date1 AND f.fecha <= :date2 "
	      + "ORDER BY f.fecha DESC ",
			  nativeQuery = true)
	  List<FotoDto> getFotosBetweenDates(
	      @Param("date1") Timestamp date1, @Param("date2") Timestamp date2);

}
