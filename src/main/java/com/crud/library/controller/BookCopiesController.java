package com.crud.library.controller;

import com.crud.library.dto.BookCopiesDto;
import com.crud.library.mapper.BookCopiesMapper;
import com.crud.library.service.BookCopiesService;
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

    @GetMapping(value = "/{title}")
    public ResponseEntity<Set<BookCopiesDto>> getAvailableCopies(@PathVariable String title) {
        return ResponseEntity.ok(bookCopiesMapper.mapToBookCopiesDtoSet(bookCopiesService.getAvailable(title)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookCopiesDto> createBookCopies(@RequestBody BookCopiesDto bookCopiesDto) throws Exception {
        return ResponseEntity.ok().body(bookCopiesMapper.mapToBookCopiesDto(bookCopiesService.createCopies(bookCopiesMapper.mapToBookCopies(bookCopiesDto))));
    }

    @PatchMapping
    public ResponseEntity<BookCopiesDto> changeOfStatus(@RequestBody BookCopiesDto bookCopiesDto) throws Exception {
        return ResponseEntity.ok().body(bookCopiesMapper.mapToBookCopiesDto(bookCopiesService.changeBookStatus(bookCopiesMapper.mapToBookCopies(bookCopiesDto))));
    }
}
