package com.example.MsAttorney.service;

import com.example.MsAttorney.domain.dto.AttorneyRequestDto;
import com.example.MsAttorney.domain.dto.AttorneyResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AttorneyService {
    Mono<AttorneyResponseDto> findById(Integer id);
    Flux<AttorneyResponseDto> findAll();
    Mono<AttorneyResponseDto> create(AttorneyRequestDto request);
    Mono<AttorneyResponseDto> update(AttorneyRequestDto request, Integer id);
    Mono<Void> delete(Integer id);

    Flux<AttorneyResponseDto> findAllInactive();

    void changeStatusToInactive(int attorneyId);
}
