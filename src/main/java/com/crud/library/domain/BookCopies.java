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
    private Long id;
    private String status;
    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;
}
