package com.springBoot.libraryManagement.repository;

import com.springBoot.libraryManagement.model.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Long> {

}
