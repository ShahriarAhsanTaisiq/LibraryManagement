package com.springBoot.libraryManagement.controller;

import com.springBoot.libraryManagement.model.LibraryMember;
import com.springBoot.libraryManagement.service.LibraryMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class LibraryMemberController {
    @Autowired
    private LibraryMemberService libraryMemberService;

    @PostMapping
    public ResponseEntity<LibraryMember> createLibraryMember(@RequestBody LibraryMember libraryMember){
        LibraryMember saveLibraryMember = libraryMemberService.saveLibraryMember(libraryMember);
        return ResponseEntity.ok(saveLibraryMember);
    }

    @GetMapping
    public ResponseEntity<List<LibraryMember>> getAllMembers(){
        List<LibraryMember> members = libraryMemberService.getAllLibraryMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryMember> getMemberById(@PathVariable Long id){
        Optional<LibraryMember> member = libraryMemberService.getLibraryMemberById(id);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        libraryMemberService.deleteLibraryMember(id);
        return ResponseEntity.ok().build();
    }
}
