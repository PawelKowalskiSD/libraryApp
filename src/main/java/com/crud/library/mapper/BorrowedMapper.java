package com.crud.library.mapper;

import com.crud.library.domain.Borrowed;
import com.crud.library.dto.BorrowedDto;
import org.springframework.stereotype.Service;

@Service
public class BorrowedMapper {

    public Borrowed mapToBorrowed(final BorrowedDto borrowedDto) {
        return new Borrowed(
                borrowedDto.getDateOfBorrowing(),
                borrowedDto.getBookCopies(),
                borrowedDto.getReader()
                );
    }

    public BorrowedDto mapToBorrowedDto(final Borrowed borrowed) {
        return new BorrowedDto(
                borrowed.getDateOfBorrowing(),
                borrowed.getBookCopies(),
                borrowed.getReader());
    }
}
