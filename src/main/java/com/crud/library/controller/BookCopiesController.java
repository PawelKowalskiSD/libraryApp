package com.crud.library.controller;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Title;
import com.crud.library.dto.BookCopiesDto;
import com.crud.library.mapper.BookCopiesMapper;
import com.crud.library.service.BookCopiesService;
import com.crud.library.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/v1/bookCopies")
@RequiredArgsConstructor
public class BookCopiesController {

    private final BookCopiesMapper bookCopiesMapper;
    private final BookCopiesService bookCopiesService;
    private final TitleService titleService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Set<BookCopiesDto>> getAvailableCopies(@PathVariable Long id) {
        Set<BookCopies> bookCopies = bookCopiesService.getAvailable();
        return ResponseEntity.ok(bookCopiesMapper.mapToBookCopiesDtoSet(bookCopies, id));

    }

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBookCopies(@RequestBody BookCopiesDto bookCopiesDto, @PathVariable Long id) throws Exception {
        BookCopies bookCopies = bookCopiesMapper.mapToBookCopies(bookCopiesDto);

        Title title = titleService.findTitleById(id);
        bookCopies.setTitle(title);
        bookCopiesService.saveBookCopies(bookCopies);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<BookCopiesDto> changeOfStatus(@RequestBody BookCopiesDto bookCopiesDto) throws Exception {
        BookCopies bookCopies = bookCopiesService.findById(bookCopiesDto.getId());
        bookCopies.setStatus(bookCopiesDto.getStatus());
        bookCopiesService.saveBookCopies(bookCopies);
        return ResponseEntity.ok(bookCopiesMapper.mapToBookCopiesDto(bookCopies));
    }
}
