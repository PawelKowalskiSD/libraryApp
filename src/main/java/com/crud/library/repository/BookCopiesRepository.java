package com.crud.library.repository;

import com.crud.library.domain.BookCopies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public interface BookCopiesRepository extends CrudRepository<BookCopies, Long> {
    @Override
    Set<BookCopies> findAll();

    @Override
    Optional<BookCopies> findById(Long id);

    @Override
    void deleteById(Long id);
}
