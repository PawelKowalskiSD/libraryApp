package com.crud.library.repository;

import com.crud.library.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface TitleRepository extends CrudRepository<Title, Long> {

    @Override
    Title save(Title title);

    @Override
    void deleteById(Long id);

    @Override
    Optional<Title> findById(Long id);

}
