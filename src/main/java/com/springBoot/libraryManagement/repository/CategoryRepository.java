package com.springBoot.libraryManagement.repository;

import com.springBoot.libraryManagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
