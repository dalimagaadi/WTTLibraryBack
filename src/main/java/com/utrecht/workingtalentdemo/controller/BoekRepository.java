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

    @Query(value = "SELECT * FROM boek WHERE ?1 in (ISBN,titel,auteur)", nativeQuery = true)
    public List<Boek> finBySearchTerm(String searchTerm);

}

