package com.example.MsAttorney;
import com.example.MsAttorney.domain.dto.AttorneyRequestDto;
import com.example.MsAttorney.domain.dto.AttorneyResponseDto;
import com.example.MsAttorney.service.AttorneyService;
import com.example.MsAttorney.web.AttorneyController;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class MsAttorneyApplicationTests1 {

    private WebTestClient webTestClient;

    @Mock
    private AttorneyService attorneyService;

    @InjectMocks
    private AttorneyController attorneyController;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
        webTestClient = WebTestClient.bindToController(attorneyController).build();
    }

    @Test
    public void testUpdateAttorney() {
        AttorneyRequestDto requestDto = new AttorneyRequestDto();
        int id = 1;
        requestDto.setName("Paul");
        requestDto.setFatherlastname("sanchez");
        requestDto.setMotherlastname("Rodriguez");
        requestDto.setDni("952975113");
        requestDto.setCellphone("952975113");
        requestDto.setAddress("Roldan");
        requestDto.setActive("A");
        AttorneyResponseDto updatedAttorney = new AttorneyResponseDto();

        when(attorneyService.update(requestDto, id)).thenReturn(Mono.just(updatedAttorney));

        AttorneyResponseDto response = webTestClient.put()
                .uri("/v1/attorney/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestDto) // Configura el cuerpo de la solicitud como JSON
                .exchange()
                .expectStatus().isOk()
                .expectBody(AttorneyResponseDto.class)
                .returnResult().getResponseBody();

        assertEquals(response, updatedAttorney);
        verify(attorneyService, times(1)).update(requestDto, id);

        System.out.println(updatedAttorney);

    }

    @Test
    public void testDeleteAttorney() {
        int id = 1;

        when(attorneyService.delete(id)).thenReturn(Mono.empty());

        webTestClient.delete()
                .uri("/v1/attorney/{id}", id)
                .exchange()
                .expectStatus().isNoContent();

        verify(attorneyService, times(1)).delete(id);
        System.out.println(id);
    }
}
