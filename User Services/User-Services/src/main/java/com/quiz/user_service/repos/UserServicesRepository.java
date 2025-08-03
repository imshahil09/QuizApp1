package com.quiz.user_service.repos;

import com.quiz.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface  UserServicesRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
}
