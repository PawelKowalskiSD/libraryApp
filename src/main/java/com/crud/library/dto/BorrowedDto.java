package com.crud.library.dto;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Reader;
import com.crud.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowedDto {

    private Long id;
    private LocalDate dateOfBorrowing;
    private LocalDate dateOfReturn;
    private BookCopies bookCopies;
    private Reader reader;

    public BorrowedDto(LocalDate dateOfBorrowing, LocalDate dateOfReturn, BookCopies bookCopies, Reader reader) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
        this.bookCopies = bookCopies;
        this.reader = reader;
    }

    public BorrowedDto(LocalDate dateOfBorrowing, BookCopies bookCopies, Reader reader) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.bookCopies = bookCopies;
        this.reader = reader;
    }
}
