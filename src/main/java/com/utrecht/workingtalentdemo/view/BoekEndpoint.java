package com.utrecht.workingtalentdemo.view;

import com.utrecht.workingtalentdemo.controller.BoekService;
import com.utrecht.workingtalentdemo.controller.ReserveringService;
import com.utrecht.workingtalentdemo.controller.UserService;
import com.utrecht.workingtalentdemo.model.Boek;
import com.utrecht.workingtalentdemo.model.Exemplaar;

import com.utrecht.workingtalentdemo.model.Reservering;
import com.utrecht.workingtalentdemo.model.User;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BoekEndpoint {
    @Autowired
    BoekService bs;

    @Autowired
    ReserveringService rs;

    @Autowired
    UserService us;
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
    
    @GetMapping("searchAllBook")
    public List<Boek> searchAllBook(){
        List<Boek> gevondenAllBoeken = new ArrayList<Boek>();
        gevondenAllBoeken = bs.searchAllBook();
        return gevondenAllBoeken;
    }

    @PostMapping("reserveer/{isbn}/{email}")
    public Reservering addReservering(@PathVariable String isbn, @PathVariable String email){
        User _user = us.searchUser(email);
        Reservering _res = rs.addReservering(isbn, _user);
         return _res;
    }

    @PostMapping("addBoek")
    public void addBoek(@RequestBody Boek boek){
        bs.addBoek(boek);
    }
    
    @PutMapping("bewerkBoek/{isbn}")
    public void bewerkBoek(@PathVariable String isbn, @RequestBody Boek boek) {
    	bs.addBoek(boek);
    }
    
    @PostMapping("addExemplaar/{isbn}")
    public void addExemplaar(@RequestBody List<Exemplaar> exemplaren, @PathVariable String isbn) {
    	bs.voegExemplaarToe(isbn, exemplaren);
    }
    
    @GetMapping("searchExemplaarAmount/{isbn}")
    public int searchExemplaar(@PathVariable String isbn) {
    	return bs.searchExemplaarAmount(isbn);
    }
    
    @GetMapping("searchBoekAantal/{isbn}")
    public int searchBoekAantal(@PathVariable String isbn) {
    	return bs.searchBoekAantal(isbn);
    }
}
