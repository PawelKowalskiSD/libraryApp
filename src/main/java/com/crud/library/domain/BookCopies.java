package com.crud.library.domain;

import jakarta.persistence.*;
import lombok.*;

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
}
