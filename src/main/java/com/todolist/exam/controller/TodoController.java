package com.todolist.exam.controller;

import com.todolist.exam.model.Todo;
import com.todolist.exam.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Todo>> read() {
        ResponseEntity<List<Todo>> result = new ResponseEntity<>(todoService.getData(), HttpStatus.OK);
        log.info(result);

        return result;
    }

    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> create(@RequestBody Todo todo) {
        log.info(todo);
        todoService.register(todo);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> update(@PathVariable("id") long id) {
        todoService.modify(id);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        todoService.remove(id);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
