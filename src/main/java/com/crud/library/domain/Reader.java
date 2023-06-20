package com.crud.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reader {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private Date accountCreationDate;

}
