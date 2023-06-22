package com.crud.library.repository;

import com.crud.library.domain.BookCopies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopiesRepository extends CrudRepository<BookCopies, Long> {
}
