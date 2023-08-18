package com.crud.library.dto;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Reader;
import com.crud.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BorrowedDto {

    private Long id;
    private LocalDate dateOfBorrowing = LocalDate.now();
    private LocalDate dateOfReturn = LocalDate.now();
    private Long bookCopiesId;
    private Long readerId;

    public BorrowedDto(LocalDate dateOfBorrowing, Long bookCopies, Long reader) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.bookCopiesId = bookCopies;
        this.readerId = reader;
    }
}
