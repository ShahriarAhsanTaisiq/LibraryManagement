package com.springBoot.libraryManagement.repository;

import com.springBoot.libraryManagement.model.LoanRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRecordRepository extends JpaRepository<LoanRecord, Long> {

}
