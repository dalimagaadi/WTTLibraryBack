package com.utrecht.workingtalentdemo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.utrecht.workingtalentdemo.model.Exemplaar;

@Component
public interface ExemplaarRepository extends JpaRepository<Exemplaar, Long> {}