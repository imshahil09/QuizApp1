package com.quiz.user_service.services;

import com.quiz.user_service.DTOs.UserDto;
import com.quiz.user_service.converter.UserConverter;
import com.quiz.user_service.entities.User;
import com.quiz.user_service.enums.Role;
import com.quiz.user_service.repos.UserServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.quiz.user_service.converter.UserConverter.toEntity;

@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserServicesRepository userServicesRepository;

//    @Autowired
//    private UserConverter userConverter;

    public List<User> getAllUsers(){
        return userServicesRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userServicesRepository.findById(id);
    }

    @Override
    public User registerUser(UserDto userDto) {
        User user = toEntity(userDto);
        if(userServicesRepository.existsByEmail(userDto.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        return userServicesRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userServicesRepository.findById(id).map(user->{
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setMobile(updatedUser.getMobile());
            return userServicesRepository.save(user);
        }).orElseThrow(()->new RuntimeException("User Not Found"));
    }

    @Override
    public void deleteUser(Long id) {
        userServicesRepository.deleteById(id);
    }
}
