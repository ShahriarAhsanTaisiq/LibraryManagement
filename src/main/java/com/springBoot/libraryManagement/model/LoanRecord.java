package com.springBoot.libraryManagement.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LoanRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date loanDate;
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private LibraryMember libraryMember;
}
