package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TitleDto {
    private long id;
    private String title;
    private String author;
    private int yearOfPublication;
    private Set<BookCopiesDto> bookCopies = new HashSet<>();
}
