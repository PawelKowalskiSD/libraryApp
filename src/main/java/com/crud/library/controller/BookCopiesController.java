package com.crud.library.controller;

import com.crud.library.dto.BookCopiesDto;
import com.crud.library.dto.TitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/v1/bookCopies")
@RequiredArgsConstructor
public class BookCopiesController {

    @GetMapping()
    public List<BookCopiesDto> getAvailableCopies(@RequestBody TitleDto titleDto) {
        return new ArrayList<>();
    }

    @PostMapping
    public void createBookCopies(@RequestBody BookCopiesDto bookCopiesDto) {
    }

    @PutMapping
    public BookCopiesDto changeOfStatus(@RequestBody BookCopiesDto bookCopiesDto) {
        return new BookCopiesDto();
    }
}
