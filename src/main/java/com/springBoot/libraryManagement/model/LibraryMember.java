package com.springBoot.libraryManagement.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LibraryMember {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "libraryMember")
    private List<LoanRecord> loanRecords;
}
