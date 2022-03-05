package com.example.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;


    @GetMapping(value = "/todos", produces = {"application/json"})
    public ResponseEntity<List<Todo>> getListOfTodos() {
        return new ResponseEntity<>(todoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/todos", produces = {"application/json"})
    public ResponseEntity<?> create(@RequestBody Todo todo) {
        todoRepository.save(todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "todos/{id}", produces = {"application/json"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Todo data, @RequestParam boolean done) {
        Todo todo = todoRepository.getById(id);
        todo.setDate(data.getDate());
        todo.setTitle(data.getTitle());
        todo.setPriority(data.getPriority());
        todo.setDescription(data.getDescription());
        todo.setDone(done);
        todoRepository.save(todo);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("todos/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}