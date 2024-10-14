package com.springBoot.libraryManagement.controller;

import com.springBoot.libraryManagement.model.Book;
import com.springBoot.libraryManagement.service.BookeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookeService bookeService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book savedBook = bookeService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    // Get All Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookeService.getAllBook();
        return ResponseEntity.ok(books);
    }

    //Get book by id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById( @PathVariable Long id){
        Optional<Book> book = bookeService.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound()
                .build());
    }
}
