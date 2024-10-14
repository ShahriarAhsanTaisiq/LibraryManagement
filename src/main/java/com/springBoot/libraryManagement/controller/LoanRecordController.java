package com.springBoot.libraryManagement.controller;

import com.springBoot.libraryManagement.model.LoanRecord;
import com.springBoot.libraryManagement.service.LoanRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loanRecords")
public class LoanRecordController {

    @Autowired
    private LoanRecordService loanRecordService;

    @PostMapping
    public ResponseEntity<LoanRecord> createLoanRecord(@RequestBody LoanRecord loanRecord){
        LoanRecord saveLoanRecord = loanRecordService.saveLoanRecord(loanRecord);
        return ResponseEntity.ok(saveLoanRecord);
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<LoanRecord>> getLoanRecordsByMemberId(@PathVariable Long memberId){
        List<LoanRecord> loanRecords = loanRecordService.getLoanRecordsByMemberId(memberId);
        return ResponseEntity.ok(loanRecords);
    }

    @GetMapping
    public ResponseEntity<List<LoanRecord>> getAllLoanRecords(){
        List<LoanRecord> loanRecords = loanRecordService.getAllRecords();
        return ResponseEntity.ok(loanRecords);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanRecord(@PathVariable Long id){
        loanRecordService.deleteLoanRecord(id);
        return ResponseEntity.ok().build();
    }
}
