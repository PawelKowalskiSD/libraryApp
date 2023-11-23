package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BorrowedDto {
    private Long id;
    private LocalDate dateOfBorrowing = LocalDate.now();
    private LocalDate dateOfReturn = LocalDate.now();
    private Long bookCopiesId;
    private Long readerId;
}
