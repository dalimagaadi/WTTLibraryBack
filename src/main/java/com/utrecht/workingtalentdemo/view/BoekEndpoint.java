package com.utrecht.workingtalentdemo.view;

import com.utrecht.workingtalentdemo.controller.BoekService;
import com.utrecht.workingtalentdemo.model.Boek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoekEndpoint {
    @Autowired
    BoekService bs;

//    @GetMapping("getTafel/{param}")
//    public Boek getTafel(@PathVariable String param){
//        // Aan te passen om op de wijk van de tafel te zoeken
//        Boek nieuwBoek = new Boek();
//        nieuwBoek.setBijHetRaam(true);
//        nieuwBoek.setCapaciteit(3);
//        nieuwBoek.setWijk(param);
//        return nieuwBoek;
//    }
//
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
