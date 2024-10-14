package com.springBoot.libraryManagement.service;

import com.springBoot.libraryManagement.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author saveAuthor(Author author);
    List<Author> getAllAuthor();
    Optional<Author> getAuthorById(Long id);
    Author updateAuthor(Author author);
    void deleteAuthor(Long id);
}
