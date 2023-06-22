package com.crud.library.controller;

import com.crud.library.dto.TitleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/title")
@RequiredArgsConstructor
public class TitleController {

    @PostMapping
    public void createTitle(@RequestBody TitleDto titleDto) {
    }
}
