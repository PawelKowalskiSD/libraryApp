package com.crud.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddTitleToLibraryDto {
    private String title;
    private String author;
    private int yearOfPublication;
    private int bookCopies;
}
