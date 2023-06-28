package com.crud.library.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Title {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TITLE_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "TITLE", unique = true)
    private String title;

    @NotNull
    @Column(name = "AUTHOR")
    private String author;
    @NotNull
    @Column(name = "YEAR_OF_PUBLICATION")
    private int yearOfPublication;
    @OneToMany(
            targetEntity = BookCopies.class,
            mappedBy = "title",
            fetch = FetchType.LAZY)
    private Set<BookCopies> bookCopiesList = new HashSet<>();

    public Title(Long id, String title, String author, int yearOfPublication) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Title(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Title(String title, String author, int yearOfPublication, Set<BookCopies> bookCopiesList) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.bookCopiesList = bookCopiesList;
    }


}
