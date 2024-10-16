package com.springBoot.libraryManagement.controller;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.springBoot.libraryManagement.model.Author;
import com.springBoot.libraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    private ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author saveAuthor = authorService.saveAuthor(author);
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor(){
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        Optional<Author> author = authorService.getAuthorById(id);
        return author.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor){
        Optional<Author> exitingAuthor = authorService.getAuthorById(id);
        if (exitingAuthor.isPresent()){
            updatedAuthor.setId(id);
            Author saveAuthor = authorService.updateAuthor(updatedAuthor);
            return ResponseEntity.ok(saveAuthor);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()){
            authorService.deleteAuthor(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
