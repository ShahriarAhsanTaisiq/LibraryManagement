package com.springBoot.libraryManagement.repository;

import com.springBoot.libraryManagement.model.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Long> {

}
