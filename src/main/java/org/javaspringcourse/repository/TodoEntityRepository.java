package org.javaspringcourse.repository;

import org.javaspringcourse.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoEntityRepository extends JpaRepository<TodoEntity, Long> {}