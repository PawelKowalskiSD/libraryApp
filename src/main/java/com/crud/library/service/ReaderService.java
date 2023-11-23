package com.crud.library.service;

import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public Reader findReaderById(final Long id) throws Exception {
        return readerRepository.findById(id).orElseThrow(Exception::new);
    }

    public Reader createReaders(Reader reader) {
        return reader;
    }
}
