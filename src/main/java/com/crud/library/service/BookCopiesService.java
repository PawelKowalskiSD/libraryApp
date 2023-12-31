package com.crud.library.service;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Title;
import com.crud.library.exception.BookCopiesNotFoundException;
import com.crud.library.repository.BookCopiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookCopiesService {

    private final BookCopiesRepository bookCopiesRepository;
    private final TitleService titleService;

    public Set<BookCopies> getAvailable(String title) {
        return bookCopiesRepository.findAll().stream().filter(a -> !a.isOnLoan() && a.getTitle().getTitle().equals(title)).collect(Collectors.toSet());
    }

    public BookCopies findById(Long id) throws Exception {
        return bookCopiesRepository.findById(id).orElseThrow(BookCopiesNotFoundException::new);
    }

    public BookCopies createCopies(BookCopies bookCopies) throws Exception {
        Title title = titleService.findTitleById(bookCopies.getTitle().getId());
        bookCopies.setTitle(title);
        bookCopies.setOnLoan(false);
        bookCopiesRepository.save(bookCopies);
        return bookCopies;
    }

    public BookCopies changeBookStatus(BookCopies bookCopies) {
        return bookCopies;
    }
}
