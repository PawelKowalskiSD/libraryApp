package com.crud.library.service;

import com.crud.library.domain.Title;
import com.crud.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TitleService {

    private final TitleRepository titleRepository;

    public Title findTitleById(Long id) throws Exception {
        return titleRepository.findById(id).orElseThrow(Exception::new);
    }

    public Title addTitleToDatabase(Title title) {
        title.setTitle(title.getTitle());
        title.setAuthor(title.getAuthor());
        title.setYearOfPublication(title.getYearOfPublication());
        titleRepository.save(title);
        return title;
    }
}
