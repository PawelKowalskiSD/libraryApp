package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookCopies {
    
    @Id
    @GeneratedValue
    @Column(name = "BOOK_COPIES_ID")
    private Long id;

    @Column(name = "STATUS")
    private boolean isOnLoan;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    public BookCopies(boolean isOnLoan, Title title) {
        this.isOnLoan = isOnLoan;
        this.title = title;
    }
}
