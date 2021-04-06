package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Boek;
import com.utrecht.workingtalentdemo.model.Exemplaar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    
    public List<Boek> searchAllBook(){
        List<Boek> bkk = br.findAllBook();
         return bkk;
     };

    public Iterable<Boek> getAlleBoeken(){
        return br.findAll();
    }
    
    
    public void voegExemplaarToe(String isbn, List<Exemplaar> exemplaren) {
        System.out.println(isbn);
        List<Exemplaar> exemps = new ArrayList<Exemplaar>();
        for(int i =0; i < exemplaren.size(); i++){
            Exemplaar ex = er.save(exemplaren.get(i));
            exemps.add(ex);
        }
        //Haal het boek
        Boek boek = br.findByISBN(isbn).get(0);
        for(int i=0; i<exemps.size(); i++){
            Exemplaar ex = exemplaren.get(i);
            boek.getExemplaren().add(ex);
        }
        br.save(boek);

    }
    
    public int searchExemplaarAmount(String isbn) {
    	return er.searchExemplaarAmount(isbn);
    }
    
    public int searchBoekAantal(String isbn) {
    	return er.searchBoekAantal(isbn);
    }
}
