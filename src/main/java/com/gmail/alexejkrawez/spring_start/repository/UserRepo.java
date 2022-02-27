package com.gmail.alexejkrawez.spring_start.repository;
/* Для связи с базой данных */

import com.gmail.alexejkrawez.spring_start.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
