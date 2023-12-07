package com.crud.library.service;

import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
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
class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;

    @InjectMocks
    private ReaderService readerService;

    @Test
    void shouldFindReaderById() throws Exception {
        //Given
        Reader requestReader = new Reader(1L, "Dany", "Collins", LocalDate.now());
        Reader responseReader = new Reader(1L, "Dany", "Collins", LocalDate.now());
        when(readerRepository.findById(requestReader.getId())).thenReturn(Optional.of(responseReader));
        //When
        Reader result = readerService.findReaderById(requestReader.getId());
        //Then
        assertEquals(1L, result.getId());
        assertEquals("Dany", result.getFirstname());
        assertEquals("Collins", result.getLastname());
        assertEquals(LocalDate.now(), result.getAccountCreationDate());
        verify(readerRepository, times(1)).findById(requestReader.getId());
    }

    @Test
    void shouldCreateReaders() {
        //Given
        Reader requestCreateReader = new Reader("Dany", "Collins");
        Reader responseCreateReader = new Reader("Dany", "Collins");
        when(readerRepository.save(requestCreateReader)).thenReturn(responseCreateReader);
        //When
        Reader result = readerService.createReaders(requestCreateReader);
        //Then
        assertEquals("Dany", result.getFirstname());
        assertEquals("Collins", result.getLastname());
        verify(readerRepository, times(1)).save(requestCreateReader);
    }
}