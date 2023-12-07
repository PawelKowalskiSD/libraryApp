package com.crud.library.repository;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Borrowed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BorrowedRepository extends CrudRepository<Borrowed, Long> {

    @Override
    void deleteById(Long id);

    Borrowed findBorrowedByBookCopiesId(Long bookCopies_id);
}
