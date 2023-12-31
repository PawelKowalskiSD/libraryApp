package com.crud.library.repository;

import com.crud.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ReaderRepository extends CrudRepository <Reader, Long> {

    @Override
    void deleteById(Long id);

    @Override
    Optional<Reader> findById(Long id);
}
