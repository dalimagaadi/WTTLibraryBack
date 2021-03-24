package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Boek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BoekRepository extends JpaRepository<Boek, Long> {

    @Query(value = "SELECT * from boek WHERE isbn = ?1", nativeQuery = true)
    public List<Boek> findBoekByISBN(String isbn);

    @Query(value = "SELECT * FROM boek WHERE ISBN LIKE %?1% OR titel LIKE %?1% OR auteur LIKE %?1% OR tags LIKE %?1%", nativeQuery = true)
    public List<Boek> finBySearchTerm(String searchTerm);
    
    @Query(value = "SELECT * FROM `boek` ORDER BY `boek`.`titel` ASC", nativeQuery = true)
    public List<Boek> findAllBook();

    List<Boek> findByISBN(String ISBN);
}

