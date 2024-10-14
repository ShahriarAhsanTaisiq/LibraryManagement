package com.springBoot.libraryManagement.service;

import com.springBoot.libraryManagement.model.LibraryMember;
import com.springBoot.libraryManagement.repository.LibraryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService{

    private LibraryMemberRepository libraryMemberRepository;
    @Override
    public LibraryMember saveLibraryMember(LibraryMember libraryMember) {
        return libraryMemberRepository.save(libraryMember);
    }

    @Override
    public List<LibraryMember> getAllLibraryMembers() {
        return libraryMemberRepository.findAll();
    }

    @Override
    public Optional<LibraryMember> getLibraryMemberById(Long id) {
        return libraryMemberRepository.findById(id);
    }

    @Override
    public void deleteLibraryMember(Long id) {
        libraryMemberRepository.deleteById(id);
    }
}
