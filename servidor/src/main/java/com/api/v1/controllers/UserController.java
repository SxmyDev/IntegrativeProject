package com.api.v1.controllers;

import com.api.v1.models.UserModel;
import com.api.v1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@Valid @RequestBody UserModel user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id){
        return userService.getById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public UserModel updateUserById(@RequestBody UserModel updatedUser, @PathVariable Long id){
        return userService.updateById(updatedUser, id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        boolean ok = userService.deleteUser(id);
        if(ok){
            return "User with id " + id + " deleted";
        } else {
            return "Unable to delete user with id " + id;
        }
    }
}
