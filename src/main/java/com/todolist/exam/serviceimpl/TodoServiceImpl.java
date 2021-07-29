package com.todolist.exam.serviceimpl;

import com.todolist.exam.mapper.TodoMapper;
import com.todolist.exam.model.Todo;
import com.todolist.exam.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    @Autowired
    private final TodoMapper todoMapper;

    @Override
    public List<Todo> getData() {
        return todoMapper.read();
    }

    @Override
    public Todo getDataById(long id) {
        return todoMapper.readById(id);
    }

    @Override
    public void register(Todo todo) {
        log.info(todo);
        todoMapper.create(todo);
    }
    @Override
    public void modify(long id) {
        Todo todo = getDataById(id);
        todo.setCompleted(!todo.isCompleted());
        log.info(todo);
        todoMapper.update(todo);
    }

    @Override
    public void remove(long id) {
        log.info(id);
        todoMapper.delete(id);
    }

}
