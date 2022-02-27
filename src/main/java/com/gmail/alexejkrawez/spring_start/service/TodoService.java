package com.gmail.alexejkrawez.spring_start.service;

import com.gmail.alexejkrawez.spring_start.entity.TodoEntity;
import com.gmail.alexejkrawez.spring_start.entity.UserEntity;
import com.gmail.alexejkrawez.spring_start.model.TodoModel;
import com.gmail.alexejkrawez.spring_start.repository.TodoRepo;
import com.gmail.alexejkrawez.spring_start.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public TodoModel createTodo(TodoEntity todoEntity, Long userId) {
        UserEntity userEntity = userRepo.findById(userId).get();
        todoEntity.setUserEntity(userEntity);
        return TodoModel.toModel(todoRepo.save(todoEntity));
    }

    public TodoModel completeTodo(Long id) {
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setCompleted(!todoEntity.getCompleted()); // передаём отрицание того значения, которое сейчас
                                                             // записано в todoEntity
        return TodoModel.toModel(todoRepo.save(todoEntity));
    }


}
