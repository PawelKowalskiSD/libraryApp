package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReadBorrowedDto {
    private Long id;
    private LocalDate dateOfBorrowing;
    private LocalDate dateOfReturn;
    private Long bookCopiesId;
    private Long readerId;
}
