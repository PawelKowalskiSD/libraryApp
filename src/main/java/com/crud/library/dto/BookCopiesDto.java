package com.crud.library.dto;

import com.crud.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookCopiesDto {

    private Long id;
    private String status;
    private Long titleId;
}
