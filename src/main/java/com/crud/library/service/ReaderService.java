package com.crud.library.service;

import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader findReaderById(final Long id) throws Exception {
        return readerRepository.findById(id).orElseThrow(Exception::new);
    }

    public void deleteReaderById(Long id) {
        readerRepository.deleteById(id);
    }
}
