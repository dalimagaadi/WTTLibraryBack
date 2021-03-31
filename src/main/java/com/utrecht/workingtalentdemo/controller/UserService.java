package com.utrecht.workingtalentdemo.controller;

import com.utrecht.workingtalentdemo.model.Boek;
import com.utrecht.workingtalentdemo.model.Exemplaar;
import com.utrecht.workingtalentdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("userService")
public class UserService {
    @Autowired // Dependency injection  Java EE Bean Architecture
    private UserRepository ur;
    
    public User loginUser(String email, String password){
    	User dummy = ur.loginUser(email, password);
         return dummy;
    }

    public User searchUser(String email){
        User dummy = ur.findUser(email);
        return dummy;
    }


    public void addUser(User user) {
    	ur.save(user);
    }
}


