package com.gmail.alexejkrawez.spring_start.repository;

import com.gmail.alexejkrawez.spring_start.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {

}
