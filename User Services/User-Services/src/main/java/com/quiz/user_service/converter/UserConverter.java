package com.quiz.user_service.converter;

import com.quiz.user_service.DTOs.UserDto;
import com.quiz.user_service.entities.User;

public class UserConverter {

        // Convert Entity to DTO
        public static UserDto toDto(User user) {
            if (user == null) return null;

            UserDto dto = new UserDto();
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setMobile(user.getMobile());
            dto.setRole(user.getRole());
            dto.setActive(user.isActive());
            dto.setCreatedAt(user.getCreatedAt());
            dto.setUpdatedAt(user.getUpdatedAt());
            return dto;
        }

        // Convert DTO to Entity
        public static User toEntity(UserDto dto) {
            if (dto == null) return null;
            User user = new User();
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setMobile(dto.getMobile());
            user.setRole(dto.getRole());
            user.setActive(dto.isActive());
            user.setCreatedAt(dto.getCreatedAt());
            user.setUpdatedAt(dto.getUpdatedAt());
            return user;
        }

}
