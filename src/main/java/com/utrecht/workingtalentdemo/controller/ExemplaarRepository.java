package com.utrecht.workingtalentdemo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.utrecht.workingtalentdemo.model.Boek;
import com.utrecht.workingtalentdemo.model.Exemplaar;

@Component
public interface ExemplaarRepository extends JpaRepository<Exemplaar, Long> {

	@Query(value = "SELECT * FROM boek_exemplaren WHERE boek_isbn LIKE ?1%", nativeQuery = true)
	public List<Exemplaar> searchExemplaarAmount(String isbn);

}