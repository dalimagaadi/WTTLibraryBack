package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Exemplaar;
import com.utrecht.workingtalentdemo.model.Reservering;
import com.utrecht.workingtalentdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Service("reserveringService")
public class ReserveringService {
    @Autowired
    ExemplaarRepository er;

    @Autowired
    ReserveringRepository rr;

    @Autowired
    UserRepository ur;
    public Reservering addReservering(String isbn, User user){
        Exemplaar beschikbaarExemplaar = getAvailableExemplaar(isbn);
        
        Reservering reservering = new Reservering();
        reservering.setExemplaar(beschikbaarExemplaar);
        String datum = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        reservering.setReserveringsDatum(datum);
        reservering.setIsbn(isbn);
        beschikbaarExemplaar.setStatus("Gereserveerd");
        er.save(beschikbaarExemplaar);

        user.getReserveringen().add(reservering);
        ur.save(user);
        return rr.save(reservering);
    }

    public Exemplaar getAvailableExemplaar(String isbn){
         Exemplaar ex = er.getExemplaar(isbn);
         return ex;
    }
}
