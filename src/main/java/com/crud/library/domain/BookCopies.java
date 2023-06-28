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
    private String status;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    public BookCopies(String status) {
        this.status = status;
    }

    public BookCopies(String status, Title title) {
        this.status = status;
        this.title = title;
    }

    public BookCopies(Title title) {
        this.title = title;
    }
}
