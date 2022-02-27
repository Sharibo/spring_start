package com.gmail.alexejkrawez.spring_start.service;
/* Для описания логики обработки запросов клиента */

import com.gmail.alexejkrawez.spring_start.entity.UserEntity;
import com.gmail.alexejkrawez.spring_start.exception.UserAlreadyExistException;
import com.gmail.alexejkrawez.spring_start.exception.UserNotFoundException;
import com.gmail.alexejkrawez.spring_start.model.UserModel;
import com.gmail.alexejkrawez.spring_start.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException {
        if (userRepo.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(userEntity);
    }

    public UserModel getOne(Long id) throws UserNotFoundException {

        UserEntity user = userRepo.findById(id).get();

        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }

        return UserModel.toModel(user);
    }


    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
