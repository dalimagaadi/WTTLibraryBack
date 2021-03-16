package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Boek;
import com.utrecht.workingtalentdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Long> {
	
    @Query(value = "SELECT * FROM user WHERE (email =?1 AND password = ?2)" , nativeQuery = true)
    public User findUser(String email, String password);


}