package com.springBoot.libraryManagement.repository;

import com.springBoot.libraryManagement.model.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long> {
    List<LoanRecord> findByLibraryMemberId(Long memberId);
}
