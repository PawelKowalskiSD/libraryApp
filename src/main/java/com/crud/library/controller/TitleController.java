package com.crud.library.controller;

import com.crud.library.dto.AddTitleToLibraryDto;
import com.crud.library.dto.TitleDto;
import com.crud.library.mapper.TitleMapper;
import com.crud.library.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/title")
@RequiredArgsConstructor
public class TitleController {

    private final TitleService titleService;
    private final TitleMapper titleMapper;

    @PostMapping(value = "/adds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TitleDto> addTitle(@RequestBody AddTitleToLibraryDto addTitleToLibraryDto) {
        return ResponseEntity.ok().body(titleMapper.mapToTitleDto(titleService.addTitleToDatabase(titleMapper.mapToTitle(addTitleToLibraryDto))));
    }
}
