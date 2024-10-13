package com.springBoot.libraryManagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;

}
