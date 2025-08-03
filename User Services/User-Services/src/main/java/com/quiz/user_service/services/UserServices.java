package com.quiz.user_service.services;

import com.quiz.user_service.DTOs.UserDto;
import com.quiz.user_service.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {

     List<User> getAllUsers();

     Optional<User> getUserById(Long id);

     User registerUser(UserDto userDto);

     User updateUser(Long id,User user);

     void deleteUser(Long id);
}
