package com.quiz.user_service.controller;

import com.quiz.user_service.DTOs.UserDto;
import com.quiz.user_service.entities.User;
import com.quiz.user_service.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserServiceControoller {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userServices.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){
        try{
            User createdUser = userServices.registerUser(userDto);
            return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
        } catch (RuntimeException ex){
            return new ResponseEntity<>(null,HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        try{
            User updated = userServices.updateUser(id,user);
            return ResponseEntity.ok(updated);
        }catch(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userServices.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


}
