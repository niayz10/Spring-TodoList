package com.example.todolist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private Long id;

    @Column(nullable = false)
    int priority;

    @Column(nullable = false)
    boolean done;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    Date date;

    String description;

}