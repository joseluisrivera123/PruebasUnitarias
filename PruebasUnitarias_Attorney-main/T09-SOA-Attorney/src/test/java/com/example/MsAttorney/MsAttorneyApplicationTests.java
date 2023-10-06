package com.example.MsAttorney;

import com.example.MsAttorney.domain.dto.AttorneyRequestDto;
import com.example.MsAttorney.domain.dto.AttorneyResponseDto;
import com.example.MsAttorney.web.AttorneyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MsAttorneyApplicationTests {

	@Autowired
	private AttorneyController attorneyController;
	@Test
	void FindAllTest() {
		Flux<AttorneyResponseDto> result = attorneyController.findAll();
		System.out.println(result.collectList().block());
		assertNotNull(result.collectList().block());
	}

	@Test
	void FindAllInactiveTest() {
		Flux<AttorneyResponseDto> result = attorneyController.findAllInactive();
		System.out.println(result.collectList().block());
		assertNotNull(result.collectList().block());
	}

	@Test
	void ListIIDTest() {
		int id = 2;
		Mono<AttorneyResponseDto> result = attorneyController.findById(id);
		AttorneyResponseDto attorneyResponse = result.block();

		if (attorneyResponse != null) {
			System.out.println(attorneyResponse);
			assertNotNull(attorneyResponse);
		} else {
			System.out.println("No se encontró ningún abogado con el ID: " + id);
			fail("El resultado debería ser no nulo.");
		}
	}


	@Test
	void CreateAttorneyTest(){
		AttorneyRequestDto attorneyRequestDto = new AttorneyRequestDto("pablo","Doe","Smith","12345678","123456789","123 Main St","A");
		Mono<AttorneyResponseDto> result = attorneyController.create(attorneyRequestDto);
		AttorneyResponseDto createdAttorney = result.block();
		assertNotNull(createdAttorney);

		Mono<AttorneyResponseDto> findResult = attorneyController.findById(createdAttorney.getId());
		AttorneyResponseDto foundAttorney = findResult.block();

		assertNotNull(foundAttorney);
		assertEquals(createdAttorney.getId(), foundAttorney.getId());
	}
}