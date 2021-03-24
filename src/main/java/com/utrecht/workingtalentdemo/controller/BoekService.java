package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Boek;
import com.utrecht.workingtalentdemo.model.Exemplaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("boekService")
public class BoekService {
    @Autowired // Dependency injection  Java EE Bean Architecture
    private BoekRepository br;
    @Autowired
    private ExemplaarRepository er;

    public void addBoek(Boek boek){
        br.save(boek);
    }
    public void deleteBoek(long id){
        br.deleteById(id);
    }

    public Boek getBoek(String isbn){
        Boek bk = br.findBoekByISBN(isbn).get(0);
        return bk;
    };
    public List<Boek> searchBook(String searchTerm){
       List<Boek> bk = br.finBySearchTerm(searchTerm);
        return bk;
    };

    public Iterable<Boek> getAlleBoeken(){
        return br.findAll();
    }
    
    
    public void voegExemplaarToe(String isbn, Exemplaar exemplaar) {
//        System.out.println(exemplaar);
    exemplaar = er.save(exemplaar);
//    Exemplaar ex = er.save(exemplaar);
    Boek boek = br.findByISBN(isbn).get(0);
    boek.getExemplaren().add(exemplaar);
    br.save(boek);
    System.out.println("Test");
    }
    
    public int searchExemplaarAmount(String isbn) {
    	return er.searchExemplaarAmount(isbn);

    	
    }
}
