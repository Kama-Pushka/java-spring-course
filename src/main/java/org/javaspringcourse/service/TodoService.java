package org.javaspringcourse.service;

import lombok.RequiredArgsConstructor;
import org.javaspringcourse.dto.TodoDto;
import org.javaspringcourse.model.TodoEntity;
import org.javaspringcourse.repository.TodoEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoEntityRepository todoEntityRepository;

    @Transactional(readOnly = true)
    public List<TodoDto> findAll() {
        return todoEntityRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    private TodoDto toDto(TodoEntity todo) {
        return new TodoDto(todo.getName(), todo.getEvents().stream().toList());
    }

    @Transactional
    public void save(TodoDto todoDto) {
        var todoEntity = new TodoEntity(todoDto.name(), new HashSet<>(todoDto.events()));
        todoEntityRepository.save(todoEntity);
    }
}
