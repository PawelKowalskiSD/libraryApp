package com.crud.library.dto;

import com.crud.library.domain.Reader;
import com.crud.library.domain.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowedDto {

    private Long id;
    private Date dateOfBorrowing;
    private Date dateOfReturn;
    private Reader reader;
    private Title title;
}
