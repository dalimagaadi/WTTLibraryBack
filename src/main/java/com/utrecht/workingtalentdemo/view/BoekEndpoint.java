package com.utrecht.workingtalentdemo.view;

import com.utrecht.workingtalentdemo.controller.BoekService;
import com.utrecht.workingtalentdemo.model.Boek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoekEndpoint {
    @Autowired
    BoekService bs;

    @GetMapping("getBoek/{isbn}")
    public Boek getBoek(@PathVariable String isbn){
        Boek nieuwBoek = new Boek();
        nieuwBoek = bs.getBoek(isbn);
        return nieuwBoek;
    }

    @GetMapping("searchBook/{searchTerm}")
    public List<Boek> searchBook(@PathVariable String searchTerm){
        List<Boek> gevondenBoeken = new ArrayList<Boek>();
        gevondenBoeken = bs.searchBook(searchTerm);
        return gevondenBoeken;
    }


//    @GetMapping("getAlleBoeken")
//    public Iterable<Boek> getAlleTafels(){
//        Iterable<Boek> alleTafels = ts.getAlleBoeken();
//        return alleTafels;
//    }
//    @DeleteMapping("deleteTafel/{id}")
//    public void deleteTafel(@PathVariable long id){
//        System.out.println("Deleted");
//        ts.deleteBoek(id);
//    }

    @PostMapping("addBoek")
    public void addBoek(@RequestBody Boek boek){
        bs.addBoek(boek);
        System.out.println("Toevoegen gelukt");
    }
}
