package com.utrecht.workingtalentdemo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.utrecht.workingtalentdemo.model.Boek;
import com.utrecht.workingtalentdemo.model.Exemplaar;

@Component
public interface ExemplaarRepository extends JpaRepository<Exemplaar, Long> {

	@Query(value = "SELECT COUNT(*) FROM `boek_exemplaren` WHERE boek_isbn = ?1", nativeQuery = true)
	public int searchExemplaarAmount(String isbn);
	
	@Query(value = "SELECT `aantal` FROM `boek` WHERE isbn = ?1", nativeQuery = true)
	public int searchBoekAantal(String isbn);
	
	

	@Query(value = "SELECT ex.* from `exemplaar` ex inner join `boek_exemplaren` bx on ex.id = bx.exemplaren_id " +
			"WHERE bx.boek_isbn = ?1 and ex.status = 'beschikbaar' " +
			"LIMIT 1", nativeQuery = true)
	public Exemplaar getExemplaarByISBN(String isbn);
}
