package com.springBoot.libraryManagement.repository;

import com.springBoot.libraryManagement.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
