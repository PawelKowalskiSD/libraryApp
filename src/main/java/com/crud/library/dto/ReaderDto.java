package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReaderDto {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate accountCreationDate;
}
