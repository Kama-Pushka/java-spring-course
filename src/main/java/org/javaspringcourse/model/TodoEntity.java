package org.javaspringcourse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "events", joinColumns = @JoinColumn(name = "todo_id"))
    private Set<String> events = new HashSet<String>();

    public TodoEntity(String name, Set<String> events) {
        this.name = name;
        this.events = events;
    }
}
