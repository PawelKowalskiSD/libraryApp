package com.crud.library.service;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Borrowed;
import com.crud.library.domain.Reader;
import com.crud.library.domain.Title;
import com.crud.library.repository.BorrowedRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BorrowedServiceTest {

    @Mock
    private BorrowedRepository borrowedRepository;

    @Mock
    private ReaderService readerService;

    @Mock
    private BookCopiesService bookCopiesService;

    @InjectMocks
    private BorrowedService borrowedService;

    @Test
    void returnBook() throws Exception {
        //Given
        Reader reader = new Reader(1L, "Dany", "Collins", LocalDate.now());
        Title title = new Title(1L, "Demon", "John Smith", 1999);
        BookCopies bookCopies = new BookCopies(1L, false, title);
        Borrowed requestBorrowed = new Borrowed(1L, LocalDate.of(2022, 12, 10), LocalDate.now(), bookCopies, reader);
        Borrowed responseBorrowed = new Borrowed(1L, LocalDate.of(2022, 12, 10), LocalDate.now(), bookCopies, reader);
        when(borrowedRepository.findById(requestBorrowed.getId())).thenReturn(Optional.of(responseBorrowed));
//        when(borrowedRepository.save(requestBorrowed)).thenReturn(responseBorrowed);
        //When
        Borrowed result = borrowedService.returnBook(requestBorrowed);
        //Then
        assertEquals(1L, result.getId());
        assertEquals(LocalDate.of(2022, 12, 10), result.getDateOfBorrowing());
        assertEquals(LocalDate.now(), result.getDateOfReturn());
        assertEquals(1L, result.getBookCopies().getId());
        assertFalse(result.getBookCopies().isOnLoan());
        assertEquals(1L, result.getBookCopies().getTitle().getId());
        assertEquals("Demon", result.getBookCopies().getTitle().getTitle());
        assertEquals("John Smith", result.getBookCopies().getTitle().getAuthor());
        assertEquals(1999, result.getBookCopies().getTitle().getYearOfPublication());
        assertEquals(1L, result.getReader().getId());
        assertEquals("Dany", result.getReader().getFirstname());
        assertEquals("Collins", result.getReader().getLastname());
        assertEquals(LocalDate.now(), result.getReader().getAccountCreationDate());
        verify(borrowedRepository, times(1)).findById(requestBorrowed.getId());
//        verify(borrowedRepository, times(1)).save(responseBorrowed);

    }

    @Test
    void startBorrowBook() throws Exception {
        //Given
        Reader reader = new Reader(1L, "Dany", "Collins", LocalDate.now());
        Title title = new Title(1L, "Demon", "John Smith", 1999);
        BookCopies bookCopies = new BookCopies(1L, true, title);
        Borrowed responseBorrowed = new Borrowed(1L, LocalDate.now(), null, bookCopies, reader);
        Borrowed requestBorrowed = new Borrowed(1L, LocalDate.now(), null, bookCopies, reader);
        when(bookCopiesService.findById(requestBorrowed.getBookCopies().getId())).thenReturn(responseBorrowed.getBookCopies());
        when(readerService.findReaderById(requestBorrowed.getReader().getId())).thenReturn(responseBorrowed.getReader());
        when(borrowedRepository.save(requestBorrowed)).thenReturn(responseBorrowed);
        //When
        Borrowed result = borrowedService.startBorrowBook(requestBorrowed);
        //Then
        assertEquals(1L, result.getId());
        assertEquals(LocalDate.now(), result.getDateOfBorrowing());
        assertNull(result.getDateOfReturn());
        assertEquals(1L, result.getBookCopies().getId());
        assertTrue(result.getBookCopies().isOnLoan());
        assertEquals(1L, result.getBookCopies().getTitle().getId());
        assertEquals("Demon", result.getBookCopies().getTitle().getTitle());
        assertEquals("John Smith", result.getBookCopies().getTitle().getAuthor());
        assertEquals(1999, result.getBookCopies().getTitle().getYearOfPublication());
        assertEquals(1L, result.getReader().getId());
        assertEquals("Dany", result.getReader().getFirstname());
        assertEquals("Collins", result.getReader().getLastname());
        assertEquals(LocalDate.now(), result.getReader().getAccountCreationDate());
        verify(borrowedRepository, times(1)).save(responseBorrowed);
        verify(readerService, times(1)).findReaderById(requestBorrowed.getReader().getId());
        verify(bookCopiesService, times(1)).findById(requestBorrowed.getBookCopies().getId());
    }
}