package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Reservering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveringRepository extends JpaRepository<Reservering, Long> {

}
