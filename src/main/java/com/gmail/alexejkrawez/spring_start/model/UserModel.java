package com.gmail.alexejkrawez.spring_start.model;
/* Для получения из базы данных конкретной информации и возможно её обработки */

import com.gmail.alexejkrawez.spring_start.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String username;
    private List<TodoModel> todos;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public List<TodoModel> getTodos() {
        return todos;
    }
    public void setTodos(List<TodoModel> todos) {
        this.todos = todos;
    }


    public UserModel() {
    }

    // принимает полную сущность из базы и возвращает урезанную модель на её основе
    public static UserModel toModel(UserEntity userEntity) {
        UserModel userModel = new UserModel();

        userModel.setId(userEntity.getId());
        userModel.setUsername(userEntity.getUsername());
        /* Преобразует список в стрим, для каждого элемента мэпом вызывает функцию toModel и коллектом
        *  собирает обратно в лист*/
        userModel.setTodos(userEntity.getTodos().stream().map(TodoModel::toModel).collect(Collectors.toList()));

        return userModel;
    }
}
