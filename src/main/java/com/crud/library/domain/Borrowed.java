package com.crud.library.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Borrowed {

    @Id
    @GeneratedValue
    private Long id;
    private Date dateOfBorrowing;
    private Date dateOfReturn;

    public Borrowed(Date dateOfBorrowing, Date dateOfReturn) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.dateOfReturn = dateOfReturn;
    }



}
