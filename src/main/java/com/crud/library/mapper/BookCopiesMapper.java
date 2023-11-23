package com.crud.library.mapper;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Title;
import com.crud.library.dto.BookCopiesDto;
import com.crud.library.service.TitleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookCopiesMapper {

    private final TitleService titleService;

    public BookCopies mapToBookCopies(final BookCopiesDto bookCopiesDto) throws Exception {
        Title title = titleService.findTitleById(bookCopiesDto.getTitleId());
        return new BookCopies(bookCopiesDto.getId(),
                bookCopiesDto.isOnLoan(),
                title);
    }

    public BookCopiesDto mapToBookCopiesDto(final BookCopies bookCopies) {
        return new BookCopiesDto(bookCopies.getId(),
                bookCopies.isOnLoan(),
                bookCopies.getTitle().getId());
    }

    public Set<BookCopiesDto> mapToBookCopiesDtoSet(final Set<BookCopies> bookCopiesSet) {
        return bookCopiesSet.stream()
                .map(this::mapToBookCopiesDto)
                .collect(Collectors.toSet());
    }
}
