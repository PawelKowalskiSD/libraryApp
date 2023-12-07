package com.crud.library.domain;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Set<BookCopies> bookCopiesList = new HashSet<>();

    public Title(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public Title(Long id, String title, String author, int yearOfPublication) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }
}
