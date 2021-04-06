package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Exemplaar;
import com.utrecht.workingtalentdemo.model.Reservering;
import com.utrecht.workingtalentdemo.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@Service("reserveringService")
public class ReserveringService {
    @Autowired
    ExemplaarRepository er;

    @Autowired
    ReserveringRepository rr;

    @Autowired
    UserRepository ur;

    public Reservering addReservering(String isbn, User user, String email, String titel){
        Exemplaar beschikbaarExemplaar = getAvailableExemplaar(isbn);
        
        Reservering reservering = new Reservering();
        reservering.setExemplaar(beschikbaarExemplaar);
        String datum = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        reservering.setReserveringsDatum(datum);
        reservering.setIsbn(isbn);
        beschikbaarExemplaar.setStatus("Gereserveerd");
        er.save(beschikbaarExemplaar);
        reservering.setUser(email);
        reservering.setTitel(titel);
        user.getReserveringen().add(reservering);
        ur.save(user);
//      rr.save(reservering);
        return reservering;
    }

    public Exemplaar getAvailableExemplaar(String isbn){
         Exemplaar ex = er.getExemplaarByISBN(isbn);
         return ex;
    }
    
    public List<Reservering> findReserveringen(){
    	return rr.findAllReservering();
    }
    
    public List<Reservering> findUserReservering(String email){
    	return rr.findUserReservering(email);
    }
}
