package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Transactional
@Service("userService")
public class UserService {
    @Autowired // Dependency injection  Java EE Bean Architecture
    private UserRepository ur;
    
    public User searchUser(String email, String password){
    	User dummy = ur.findUser(email, password);
         return dummy;
    } 
    
    public void addUser(User user) {
    	ur.save(user);
    }
}


