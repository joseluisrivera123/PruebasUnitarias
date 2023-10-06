package com.example.MsAttorney.web;

import com.example.MsAttorney.domain.dto.AttorneyRequestDto;
import com.example.MsAttorney.domain.dto.AttorneyResponseDto;
import com.example.MsAttorney.service.AttorneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/attorney")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class AttorneyController {
    private final AttorneyService attorneyService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<AttorneyResponseDto> findAll(){
        return this.attorneyService.findAll();
    }

    @GetMapping(value = "/inactive", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<AttorneyResponseDto> findAllInactive(){
        return this.attorneyService.findAllInactive();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AttorneyResponseDto> findById(@PathVariable Integer id){
        return this.attorneyService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AttorneyResponseDto> create(@RequestBody AttorneyRequestDto dto){
        dto.setActive("A");
        return this.attorneyService.create(dto);
    }
    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<AttorneyResponseDto> update(@RequestBody AttorneyRequestDto dto, @PathVariable Integer id){
        return this.attorneyService.update(dto,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id){

        return this.attorneyService.delete(id);
    }

}
