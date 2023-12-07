package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TitleServiceTest {
    @Mock
    private TitleRepository titleRepository;

    @InjectMocks
    private TitleService titleService;

    @Test
    void shouldFindTitleById() throws Exception {
        //Given
        Title requestTitle = new Title(1L, "Java Programing", "John Smith", 1998);
        Title responseTitle = new Title(1L, "Java Programing", "John Smith", 1998);
        when(titleRepository.findById(requestTitle.getId())).thenReturn(Optional.of(responseTitle));
        //When
        Title result = titleService.findTitleById(requestTitle.getId());
        //Then
        assertEquals(1L, result.getId());
        assertEquals("Java Programing", result.getTitle());
        assertEquals("John Smith", result.getAuthor());
        assertEquals(1998, result.getYearOfPublication());
        verify(titleRepository, times(1)).findById(requestTitle.getId());
    }

    @Test
    void shouldAddTittleToDatabase() {
        //Given
        Title requestToAddTitle = new Title( "Java Programing", "John Smith", 1998);
        Title responseTitle = new Title("Java Programing", "John Smith", 1998);
        when(titleRepository.save(requestToAddTitle)).thenReturn(responseTitle);
        //When
        Title result = titleService.addTitleToDatabase(requestToAddTitle);
        //Then
        assertEquals("Java Programing", result.getTitle());
        assertEquals("John Smith", result.getAuthor());
        assertEquals(1998, result.getYearOfPublication());
        verify(titleRepository, times(1)).save(requestToAddTitle);
    }
}