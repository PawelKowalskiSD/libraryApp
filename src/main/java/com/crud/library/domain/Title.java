package com.crud.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Title {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String yearOfPublication;
    @OneToMany
    private List<BookCopies> bookCopiesList = new ArrayList<>();
}
