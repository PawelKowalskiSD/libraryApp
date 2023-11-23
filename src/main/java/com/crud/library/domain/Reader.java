package com.crud.library.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reader {

    @Id
    @GeneratedValue
    @Column(name = "READER_ID")
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "ACCOUNT_CREATION_DATE")
    private LocalDate accountCreationDate;

    public Reader(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
