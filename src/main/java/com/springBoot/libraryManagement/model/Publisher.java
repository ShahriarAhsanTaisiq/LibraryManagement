package com.springBoot.libraryManagement.model;

import jakarta.persistence.*;
import org.hibernate.boot.model.source.spi.EmbeddedAttributeMapping;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "publisher")
    List<Book> books;
}
