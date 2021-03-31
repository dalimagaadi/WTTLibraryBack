package com.utrecht.workingtalentdemo.view;

import com.utrecht.workingtalentdemo.controller.UserService;
import com.utrecht.workingtalentdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserEndpoint {
    @Autowired
    UserService us;
    
    @GetMapping("loginUser/{email}/{password}")
    public User loginUser(@PathVariable String email, @PathVariable String password){
    	User gevondenUser = us.loginUser(email, password);
    	return gevondenUser;
    
    }

    @GetMapping("searchUser/{email}/")
    public User searchUser(@PathVariable String email){
        User gevondenUser = us.searchUser(email);
        return gevondenUser;

    }
    
    @PostMapping("addUser")
    public void addUser(@RequestBody User user){
        us.addUser(user);
        System.out.println("Toevoegen gelukt");
    }
    
}