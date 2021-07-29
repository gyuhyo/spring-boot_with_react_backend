package com.todolist.exam.service;

import com.todolist.exam.model.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getData();

    public Todo getDataById(long id);

    public void register(Todo todo);

    public void modify(long id);

    public void remove(long id);

}
