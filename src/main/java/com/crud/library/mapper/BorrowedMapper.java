package com.crud.library.mapper;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Borrowed;
import com.crud.library.domain.Reader;
import com.crud.library.dto.BorrowDto;
import com.crud.library.dto.ReadBorrowedDto;
import com.crud.library.service.BookCopiesService;
import com.crud.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowedMapper {

    private final BookCopiesService bookCopiesService;
    private final ReaderService readerService;

    public Borrowed mapToBorrowed(final BorrowDto borrowDto) throws Exception {
        BookCopies bookCopies = bookCopiesService.findById(borrowDto.getBookCopiesId());
        Reader reader= readerService.findReaderById(borrowDto.getReaderId());
        return new Borrowed(
                bookCopies,
                reader
                );
    }

    public ReadBorrowedDto mapToBorrowedDto(final Borrowed borrowed) {
        return new ReadBorrowedDto(
                borrowed.getId(),
                borrowed.getDateOfBorrowing(),
                borrowed.getDateOfReturn(),
                borrowed.getBookCopies().getId(),
                borrowed.getReader().getId());
    }
}
