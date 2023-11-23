package com.crud.library.mapper;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Borrowed;
import com.crud.library.domain.Reader;
import com.crud.library.dto.BorrowedDto;
import com.crud.library.service.BookCopiesService;
import com.crud.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowedMapper {

    private final BookCopiesService bookCopiesService;
    private final ReaderService readerService;

    public Borrowed mapToBorrowed(final BorrowedDto borrowedDto) throws Exception {
        BookCopies bookCopies = bookCopiesService.findById(borrowedDto.getBookCopiesId());
        Reader reader= readerService.findReaderById(borrowedDto.getReaderId());
        return new Borrowed(
                borrowedDto.getDateOfBorrowing(),
                bookCopies,
                reader
                );
    }

    public BorrowedDto mapToBorrowedDto(final Borrowed borrowed) {
        return new BorrowedDto(
                borrowed.getId(),
                borrowed.getDateOfBorrowing(),
                borrowed.getDateOfReturn(),
                borrowed.getBookCopies().getId(),
                borrowed.getReader().getId());
    }
}
