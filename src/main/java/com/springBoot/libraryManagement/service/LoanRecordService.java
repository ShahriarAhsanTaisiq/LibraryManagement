package com.springBoot.libraryManagement.service;

import com.springBoot.libraryManagement.model.LoanRecord;

import java.util.List;

public interface LoanRecordService {
    LoanRecord saveLoanRecord(LoanRecord loanRecord);
    List<LoanRecord> getLoanRecordsByMemberId(Long memberId);
    List<LoanRecord> getAllRecords();
    void deleteLoanRecord(Long id);
}
