package com.crud.library.controller;

import com.crud.library.dto.EndBorrowedDto;
import com.crud.library.dto.StartBorrowDto;
import com.crud.library.dto.ReadBorrowedDto;
import com.crud.library.mapper.BorrowedMapper;
import com.crud.library.service.BorrowedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/borrowed")
@RequiredArgsConstructor
public class BorrowedController {

    private final BorrowedMapper borrowedMapper;
    private final BorrowedService borrowedService;

    @PostMapping(value = "/begin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReadBorrowedDto> beginBorrow(@RequestBody StartBorrowDto startBorrowDto) throws Exception {
        return ResponseEntity.ok().body(borrowedMapper.mapToBorrowedDto(borrowedService.startBorrowBook(borrowedMapper.mapToBorrowed(startBorrowDto))));
    }

    @PostMapping(value = "/end")
    public ResponseEntity<ReadBorrowedDto> endBorrow(@RequestBody EndBorrowedDto endBorrowedDto) throws Exception {
        return ResponseEntity.ok().body(borrowedMapper.mapToBorrowedDto(borrowedService.returnBook(borrowedMapper.mapToBorrowed(endBorrowedDto))));
    }
}
