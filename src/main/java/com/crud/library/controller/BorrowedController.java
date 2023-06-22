package com.crud.library.controller;

import com.crud.library.dto.BorrowedDto;
import com.crud.library.dto.ReaderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/borrowed")
@RequiredArgsConstructor
public class BorrowedController {

    @PostMapping(value = "/begin")
    public void beginBorrow(@RequestBody BorrowedDto borrowedDto) {
    }

    @PostMapping(value = "/end")
    public void endBorrow(@RequestBody BorrowedDto borrowedDto) {
    }
}
