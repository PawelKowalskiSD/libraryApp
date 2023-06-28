package com.crud.library.service;

import com.crud.library.domain.Borrowed;
import com.crud.library.repository.BorrowedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowedService {

    private final BorrowedRepository borrowedRepository;

    public Borrowed saveBorrowed(final Borrowed borrowed) {
        return borrowedRepository.save(borrowed);
    }

    public void deleteBorrowed(final Long id) {
        borrowedRepository.deleteById(id);
    }

}
