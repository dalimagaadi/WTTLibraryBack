package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Tafel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service
public class TafelService {
    @Autowired // Dependency injection  Java EE Bean Architecture
    TafelRespository tr;

    public void addTafel(Tafel tafel){
        tr.save(tafel);
    }
    public void deleteTafel(long id){
        tr.deleteById(id);
    }

    public void getTafel(){};

    public Iterable<Tafel> getAlleTafels(){
        return tr.findAll();
    }
}
