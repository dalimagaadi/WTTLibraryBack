package com.utrecht.workingtalentdemo.view;

import com.utrecht.workingtalentdemo.controller.UserService;
import com.utrecht.workingtalentdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserEndpoint {
    @Autowired
    UserService us;
    
    @GetMapping("searchUser/{email}/{password}")
    public User searchUser(@PathVariable String email, @PathVariable String password){
    	User gevondenUser = us.searchUser(email, password);
    	return gevondenUser;
    
    }
    
    
}