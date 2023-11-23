package com.crud.library.mapper;

import com.crud.library.domain.Title;
import com.crud.library.dto.TitleDto;
import org.springframework.stereotype.Service;

@Service
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getYearOfPublication());
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYearOfPublication());
    }


}
