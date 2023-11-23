package com.crud.library.controller;

import com.crud.library.dto.ReaderDto;
import com.crud.library.mapper.ReaderMapper;
import com.crud.library.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reader")
public class ReaderController {

    private final ReaderMapper readerMapper;
    private final ReaderService readerService;


    @PostMapping
    public ResponseEntity<ReaderDto> createReader(@RequestBody ReaderDto readerDto) {
        return ResponseEntity.ok().body(readerMapper.mapToReaderDto(readerService.createReaders(readerMapper.mapToReader(readerDto))));
    }
}
