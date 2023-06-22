package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TitleDto {

    private Long id;
    private String title;
    private String author;
    private int yearOfPublication;
}
