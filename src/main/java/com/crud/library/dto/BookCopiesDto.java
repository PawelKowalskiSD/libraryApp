package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookCopiesDto {
    private Long id;
    private boolean isOnLoan;
    private Long titleId;
}
