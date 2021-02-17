package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Tafel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TafelRespository extends CrudRepository<Tafel, Long> {

}
