package com.gmail.alexejkrawez.spring_start.model;

import com.gmail.alexejkrawez.spring_start.entity.TodoEntity;

public class TodoModel {
    private Long id;
    private String title;
    private Boolean completed;

    public static TodoModel toModel(TodoEntity todoEntity) {
        TodoModel todoModel = new TodoModel();
        todoModel.setId(todoEntity.getId());
        todoModel.setTitle(todoEntity.getTitle());
        todoModel.setCompleted(todoEntity.getCompleted());
        return todoModel;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


    public TodoModel() {
    }
}


