package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleService {

    private final TitleRepository titleRepository;


    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public void deleteTitle(Long id) {
        titleRepository.deleteById(id);
    }

    public Title findTitleById(Long id) throws Exception {
        return titleRepository.findById(id).orElseThrow(Exception::new);
    }
}
