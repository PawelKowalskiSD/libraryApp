package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Borrowed {

    @Id
    @GeneratedValue
    @Column(name = "BORROWED_ID")
    private Long id;

    @Column(name = "DATE_OF_BORROWING")
    private LocalDate dateOfBorrowing;

    @Column(name = "DATE_OF_RETURN")
    private LocalDate dateOfReturn;

    @OneToOne
    @JoinColumn(name = "BOOK_COPIES_ID")
    private BookCopies bookCopies;

    @OneToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    public Borrowed(BookCopies bookCopies, Reader reader) {
        this.bookCopies = bookCopies;
        this.reader = reader;
    }

    public Borrowed(Long id) {
        this.id = id;
    }
}
