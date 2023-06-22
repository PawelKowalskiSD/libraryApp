package com.crud.library.controller;

import com.crud.library.dto.ReaderDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/reader")
public class ReaderController {

    @PostMapping
    public void createReader(@RequestBody ReaderDto readerDto) {
    }
}
