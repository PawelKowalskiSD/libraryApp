package com.crud.library.mapper;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Title;
import com.crud.library.dto.AddTitleToLibraryDto;
import com.crud.library.dto.BookCopiesDto;
import com.crud.library.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TitleMapper {

    public Title mapToTitle(final AddTitleToLibraryDto addTitleToLibraryDto) {
        return new Title(
                addTitleToLibraryDto.getTitle(),
                addTitleToLibraryDto.getAuthor(),
                addTitleToLibraryDto.getYearOfPublication());
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getYearOfPublication(),
                title.getBookCopiesList().stream()
                        .map(b -> new BookCopiesDto(b.getId(), b.isOnLoan(), b.getId())).collect(Collectors.toSet()));
    }


}
