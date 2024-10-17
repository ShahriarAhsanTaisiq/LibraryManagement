package com.springBoot.libraryManagement.controller;

import com.springBoot.libraryManagement.model.Publisher;
import com.springBoot.libraryManagement.service.PublisherService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher){
        Publisher savePublisher = publisherService.savePublisher(publisher);
        return ResponseEntity.ok(savePublisher);
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublisher(){
        List<Publisher> publishers = publisherService.getAllPublisher();
        return ResponseEntity.ok(publishers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id){
        Optional<Publisher> publisher = publisherService.getPublisherById(id);
        return publisher.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher){
        Optional<Publisher> existingPublisher = publisherService.getPublisherById(id);
        if (existingPublisher.isPresent()){
            publisher.setId(id);
            Publisher savePublisher = publisherService.update(publisher);
            return ResponseEntity.ok(savePublisher);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> deletePublisher(@PathVariable Long id){
        Optional<Publisher> publisher = publisherService.getPublisherById(id);
        if (publisher.isPresent()){
            publisherService.deletePublisher(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
