package com.springBoot.libraryManagement.service;

import com.springBoot.libraryManagement.model.LibraryMember;

import java.util.List;
import java.util.Optional;

public interface LibraryMemberService {
    LibraryMember saveLibraryMember(LibraryMember libraryMember);
    List<LibraryMember> getAllLibraryMembers();
    Optional<LibraryMember> getLibraryMemberById(Long id);
    void deleteLibraryMember(Long id);
}
