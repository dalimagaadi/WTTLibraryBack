package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Boek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service("boekService")
public class BoekService {
    @Autowired // Dependency injection  Java EE Bean Architecture
    private BoekRepository br;

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

    public Iterable<Boek> getAlleBoeken(){
        return br.findAll();
    }
}
