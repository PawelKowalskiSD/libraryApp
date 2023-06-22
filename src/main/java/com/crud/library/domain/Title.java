package com.crud.library.domain;

import jakarta.persistence.*;
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
    @Column(name = "TITLE_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "YEAR_OF_PUBLICATION")
    private int yearOfPublication;
    @OneToMany(
            targetEntity = BookCopies.class,
            mappedBy = "title",
            fetch = FetchType.LAZY)
    private List<BookCopies> bookCopiesList = new ArrayList<>();
}
