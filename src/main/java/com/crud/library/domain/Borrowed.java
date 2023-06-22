package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Date dateOfBorrowing;

    @Column(name = "DATE_OF_RETURN")
    private Date dateOfReturn;
    @OneToOne
    @JoinColumn(name = "BOOK_COPIES_ID")
    private BookCopies bookCopies;
    @OneToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    public Borrowed(Date dateOfBorrowing, Date dateOfReturn) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
    }



}
