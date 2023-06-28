package com.crud.library.mapper;

import com.crud.library.domain.BookCopies;
import com.crud.library.dto.BookCopiesDto;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookCopiesMapper {

    public BookCopies mapToBookCopies(final BookCopiesDto bookCopiesDto) {
        return new BookCopies(bookCopiesDto.getId(),
                bookCopiesDto.getStatus(),
                bookCopiesDto.getTitle());
    }

    public BookCopiesDto mapToBookCopiesDto(final BookCopies bookCopies) {
        return new BookCopiesDto(bookCopies.getId(),
                bookCopies.getStatus(),
                bookCopies.getTitle());
    }

    public Set<BookCopiesDto> mapToBookCopiesDtoSet(final Set<BookCopies> bookCopiesSet, Long id) {
        return bookCopiesSet.stream()
                .filter(a -> a.getStatus().equals("available") && a.getTitle().getId().equals(id))
                .map(this::mapToBookCopiesDto)
                .collect(Collectors.toSet());
    }
}
