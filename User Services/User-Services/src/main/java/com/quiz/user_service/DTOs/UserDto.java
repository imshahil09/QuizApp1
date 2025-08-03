package com.quiz.user_service.DTOs;

import com.quiz.user_service.enums.Role;

import java.time.LocalDateTime;


public class UserDto {

        private String name;
        private String email;
        private String mobile;
        private Role role;
        private boolean isActive;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public UserDto() {
        }

        public UserDto(String name, String email, String mobile, Role role, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
                this.name = name;
                this.email = email;
                this.mobile = mobile;
                this.role = role;
                this.isActive = isActive;
                this.createdAt = createdAt;
                this.updatedAt = updatedAt;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getMobile() {
                return mobile;
        }

        public void setMobile(String mobile) {
                this.mobile = mobile;
        }

        public Role getRole() {
                return role;
        }

        public void setRole(Role role) {
                this.role = role;
        }

        public boolean isActive() {
                return isActive;
        }

        public void setActive(boolean active) {
                isActive = active;
        }

        public LocalDateTime getCreatedAt() {
                return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
                this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
                return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
                this.updatedAt = updatedAt;
        }
}
