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
    private  BookeService bookeService;

    public BookController(BookeService bookeService) {
        this.bookeService = bookeService;
    }

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

    //Get book by isbn
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn){
        Optional<Book> book = bookeService.getBookByIsbn(isbn);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Optional<Book> existingBook = bookeService.getBookById(id);
        if (existingBook.isPresent()){
            book.setId(id);
            Book updateBook = bookeService.updateBook(book);
            return ResponseEntity.ok(updateBook);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        Optional<Book> book = bookeService.getBookById(id);
        if (book.isPresent()){
            bookeService.deleteBook(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
