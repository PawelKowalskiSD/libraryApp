package com.crud.library.service;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Borrowed;
import com.crud.library.domain.Reader;
import com.crud.library.repository.BorrowedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BorrowedService {

    private final BorrowedRepository borrowedRepository;
    private final BookCopiesService bookCopiesService;
    private final ReaderService readerService;

    public Borrowed returnBook(Borrowed borrowed) {
        return borrowed;
    }

    public Borrowed startBorrowBook(Borrowed borrowed) throws Exception {
        BookCopies bookCopies = bookCopiesService.findById(borrowed.getBookCopies().getId());
        Reader reader = readerService.findReaderById(borrowed.getReader().getId());
        borrowed.setBookCopies(bookCopies);
        borrowed.setReader(reader);
        borrowed.setDateOfBorrowing(LocalDate.now());
        borrowedRepository.save(borrowed);
        return borrowed;
    }
}
