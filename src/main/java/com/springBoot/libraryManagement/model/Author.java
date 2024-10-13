package com.springBoot.libraryManagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
