package com.example.MsAttorney.service.impl;

import com.example.MsAttorney.domain.dto.AttorneyRequestDto;
import com.example.MsAttorney.domain.dto.AttorneyResponseDto;
import com.example.MsAttorney.domain.mapper.AttorneyMapper;
import com.example.MsAttorney.exception.ResourceNotFoundException;
import com.example.MsAttorney.repository.AttorneyRepository;
import com.example.MsAttorney.service.AttorneyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.example.MsAttorney.domain.mapper.AttorneyMapper.toModel;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttorneyServiceImpl implements AttorneyService {

    private  final AttorneyRepository attorneyRepository;
    @Override
    public Mono<AttorneyResponseDto> findById(Integer id) {
        return this.attorneyRepository.findById(id)
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Flux<AttorneyResponseDto> findAll() {
        return this.attorneyRepository.findAll()
                .filter(representative -> representative.getActive().equals("A"))
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Flux<AttorneyResponseDto> findAllInactive() {
        return this.attorneyRepository.findAll()
                .filter(representative -> representative.getActive().equals("I"))
                .map(AttorneyMapper::toDto);
    }

    @Override
    public void changeStatusToInactive(int attorneyId) {

    }

    @Override
    public Mono<AttorneyResponseDto> create(AttorneyRequestDto request) {
        return this.attorneyRepository.save(toModel(request))
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Mono<AttorneyResponseDto> update(AttorneyRequestDto request, Integer id) {
        return this.attorneyRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(representative -> this.attorneyRepository.save(toModel(representative.getId(),request)))
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return this.attorneyRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(representative -> {
                    representative.setActive("I");
                    return this.attorneyRepository.save(representative);
                })
                .doOnSuccess(unused -> log.info("Se elimino el siguiente ID " +id))
                .then();
    }


}
