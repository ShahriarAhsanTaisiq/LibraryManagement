package com.springBoot.libraryManagement.service;

import com.springBoot.libraryManagement.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookeService {
    Book saveBook(Book book);
    List<Book> getAllBook();
    Optional<Book> getBookById(Long id);
    Optional<Book> getBookByIsbn(String isbn);
    Book updateBook(Book book);
    void deleteBook(Long id);
}
