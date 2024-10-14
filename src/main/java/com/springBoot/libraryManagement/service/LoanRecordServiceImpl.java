package com.springBoot.libraryManagement.service;

import com.springBoot.libraryManagement.model.LoanRecord;
import com.springBoot.libraryManagement.repository.LoanRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRecordServiceImpl implements LoanRecordService{

    @Autowired
    private final LoanRecordRepository loanRecordRepository;

    public LoanRecordServiceImpl(LoanRecordRepository loanRecordRepository) {
        this.loanRecordRepository = loanRecordRepository;
    }

    @Override
    public LoanRecord saveLoanRecord(LoanRecord loanRecord) {
        return loanRecordRepository.save(loanRecord);
    }

    @Override
    public List<LoanRecord> getLoanRecordsByMemberId(Long memberId) {
        return loanRecordRepository.findByLibraryMemberId(memberId);
    }

    @Override
    public List<LoanRecord> getAllRecords() {
        return loanRecordRepository.findAll();
    }

    @Override
    public void deleteLoanRecord(Long id) {
        loanRecordRepository.deleteById(id);
    }
}
