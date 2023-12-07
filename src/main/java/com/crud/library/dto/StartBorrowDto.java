package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StartBorrowDto {
    private Long bookCopiesId;
    private Long readerId;
}
