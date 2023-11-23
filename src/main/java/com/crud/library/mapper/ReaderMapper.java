package com.crud.library.mapper;

import com.crud.library.domain.Reader;
import com.crud.library.dto.ReaderDto;
import org.springframework.stereotype.Service;

@Service
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getFirstname(),
                readerDto.getLastname());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getFirstname(),
                reader.getLastname(),
                reader.getAccountCreationDate());
    }
}
