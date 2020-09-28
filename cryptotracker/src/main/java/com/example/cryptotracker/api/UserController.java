package com.example.cryptotracker.api;

import com.example.cryptotracker.model.Crypto;
import com.example.cryptotracker.model.User;
import com.example.cryptotracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    ///api/register Post { "username", "password", "email" } returns {"username"}
    @PostMapping("/api/register")
    public void addUser(@Valid @NotNull @RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/api/get")//for testing
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    //api/portfolio Get returns [{"symbol"}, ...]
    @GetMapping("/api/portfolio")
    public List<Crypto> getUserPortfolio(){
    	return userService.getUserPortfolio();
    }

    //api/portfolio/add Post {"symbol"}
    @PostMapping("/api/portfolio/add")
    public List<Crypto> addToPortfolio(){
    	return userService.addToPortfolio();
    }
    
    //api/portfolio/remove Delete {"symbol"}
    @DeleteMapping("api/portfolio/remove")
    public List<Crypto> removeFromPortfolio(){
    	return userService.removeFromPortfolio();
    }
    

    //still need methds for: 
    //api/login Post {"username", "password"} returns {"username"}
    //api/logout Get 
  
    
  
 

}
