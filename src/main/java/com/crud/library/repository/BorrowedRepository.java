package com.crud.library.repository;

import com.crud.library.domain.Borrowed;
import org.springframework.data.repository.CrudRepository;

public interface BorrowedRepository extends CrudRepository<Borrowed, Long> {
}
