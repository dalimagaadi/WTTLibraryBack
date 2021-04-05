package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Reservering;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface ReserveringRepository extends JpaRepository<Reservering, Long> {
	
	@Query(value = "SELECT * FROM reservering", nativeQuery = true)
    public List<Reservering> findAllReservering();
	
	@Query(value = "SELECT * FROM reservering WHERE user = ?1", nativeQuery = true)
    public List<Reservering> findUserReservering(String email);
	
}
