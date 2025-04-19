package org.javaspringcourse.controller;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.dto.TodoDto;
import org.javaspringcourse.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/get")
    public List<TodoDto> getAllTodo() {
        return todoService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTodo(@RequestBody TodoDto todoDto) {
        todoService.save(todoDto);
    }
}
