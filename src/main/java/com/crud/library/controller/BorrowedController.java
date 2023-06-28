package com.crud.library.controller;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Borrowed;
import com.crud.library.domain.Reader;
import com.crud.library.dto.BorrowedDto;
import com.crud.library.mapper.BorrowedMapper;
import com.crud.library.service.BookCopiesService;
import com.crud.library.service.BorrowedService;
import com.crud.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
@RequestMapping("/v1/borrowed")
@RequiredArgsConstructor
public class BorrowedController {

    private final BorrowedMapper borrowedMapper;
    private final BorrowedService borrowedService;
    private final ReaderService readerService;
    private final BookCopiesService bookCopiesService;

    @PostMapping(value = "/begin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> beginBorrow(@RequestBody BorrowedDto borrowedDto) throws Exception {
        BookCopies bookCopies = bookCopiesService.findById(borrowedDto.getBookCopies().getId());
        Reader reader = readerService.findReaderById(borrowedDto.getReader().getId());
        Borrowed borrowed = borrowedMapper.mapToBorrowed(borrowedDto);
        borrowed.setBookCopies(bookCopies);
        borrowed.setReader(reader);
        borrowed.setDateOfBorrowing(LocalDate.now());
        borrowedService.saveBorrowed(borrowed);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/end")
    public ResponseEntity<Void> endBorrow(@RequestBody BorrowedDto borrowedDto) {
        return ResponseEntity.ok().build();
    }
}
