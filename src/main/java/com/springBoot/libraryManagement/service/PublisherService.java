package com.springBoot.libraryManagement.service;

import com.springBoot.libraryManagement.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    List<Publisher> getAllPublisher();
    Optional<Publisher> getPublisherById(Long id);
    void deletePublisher(Long id);
}
