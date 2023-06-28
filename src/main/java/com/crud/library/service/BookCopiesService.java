package com.crud.library.service;

import com.crud.library.domain.BookCopies;
import com.crud.library.repository.BookCopiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookCopiesService {

    private final BookCopiesRepository bookCopiesRepository;

    public BookCopies saveBookCopies(final BookCopies bookCopies) {
        return bookCopiesRepository.save(bookCopies);
    }

    public Set<BookCopies> getAvailable() {
        return bookCopiesRepository.findAll();
    }

    public void deleteBookCopiesById(Long id) {
        bookCopiesRepository.deleteById(id);
    }

    public BookCopies findById(Long id) throws Exception {
        return bookCopiesRepository.findById(id).orElseThrow(Exception::new);
    }
}
