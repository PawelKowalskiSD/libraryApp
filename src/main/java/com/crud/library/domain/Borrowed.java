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

    public Borrowed(Long id, LocalDate dateOfBorrowing, LocalDate dateOfReturn) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
    }

    public Borrowed(LocalDate dateOfBorrowing, LocalDate dateOfReturn, BookCopies bookCopies, Reader reader) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
        this.bookCopies = bookCopies;
        this.reader = reader;
    }

    public Borrowed(LocalDate dateOfBorrowing, LocalDate dateOfReturn, Reader reader) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
        this.reader = reader;
    }

    public Borrowed(LocalDate dateOfBorrowing, LocalDate dateOfReturn, BookCopies bookCopies) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
        this.bookCopies = bookCopies;
    }

    public Borrowed(LocalDate dateOfBorrowing, BookCopies bookCopies, Reader reader) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.bookCopies = bookCopies;
        this.reader = reader;
    }
}
