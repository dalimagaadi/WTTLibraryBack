package com.utrecht.workingtalentdemo.view;

import com.utrecht.workingtalentdemo.controller.TafelService;
import com.utrecht.workingtalentdemo.model.Tafel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TafelEndpoint {
    @Autowired
    TafelService ts;

//    @GetMapping("addTafel/{wijk}/{capaciteit}")
//    public String roepTafelService(@PathVariable String wijk, @PathVariable int capaciteit){
//        Tafel tf = new Tafel();
//        tf.setWijk(wijk);
//        tf.setCapaciteit(capaciteit);
//        ts.addTafel(tf);
//        return "Je hebt een tafel toegevoegd";
//    }

    @GetMapping("getTafel/{param}")
    public Tafel getTafel(@PathVariable String param){
        // Aan te passen om op de wijk van de tafel te zoeken
        Tafel nieuwTafel = new Tafel();
        nieuwTafel.setBijHetRaam(true);
        nieuwTafel.setCapaciteit(3);
        nieuwTafel.setWijk(param);
        return nieuwTafel;
    }

    @GetMapping("getAlleTafels")
    public Iterable<Tafel> getAlleTafels(){
        Iterable<Tafel> alleTafels = ts.getAlleTafels();
        return alleTafels;
    }
    @DeleteMapping("deleteTafel/{id}")
    public void deleteTafel(@PathVariable long id){
        System.out.println("Deleted");
        ts.deleteTafel(id);
    }

    @PostMapping("addTafel")
    public void addTafel(@RequestBody Tafel tafel){
        ts.addTafel(tafel);
        System.out.println("Toevoegen gelukt");
    }
}
