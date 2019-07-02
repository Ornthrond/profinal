package com.joseway.ngspringsec.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.joseway.ngspringsec.model.Adresse;
import com.joseway.ngspringsec.services.AdresseService;

@SpringBootTest
class AdresseControllerApiTest {
	
	@InjectMocks
	private AdresseControllerApi controller;
	
	@Mock
	private AdresseService adresseService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		Adresse ad1 = new Adresse(1l,"street", "city");
		when(adresseService.findById(ad1.getId())).thenReturn(ad1);
		
		Adresse expected = controller.findById(ad1.getId());
		
		assertThat(expected).isNotNull();   
		assertThat(ad1).isEqualTo(expected);
	}

	@Test
	void testFindAll() {
		Adresse ad1 = new Adresse(1l,"street", "city");
		Adresse ad2 = new Adresse(2l,"street2", "city2");
		List<Adresse> adresses = new ArrayList<Adresse>();
		adresses.add(ad1); adresses.add(ad2);
		
		when(adresseService.findAll()).thenReturn(adresses);
		
		List<Adresse> expected = controller.findAll();
		
		assertThat(expected).isNotNull();
		assertThat(expected.size()).isEqualTo(2);
		assertThat(adresses).isEqualTo(expected);
	}

	@Test
	void testSave() {
		Adresse ad2 = new Adresse(2l,"street2", "city2");
		when(adresseService.save(ad2)).thenReturn(ad2);
		
		Adresse expected = controller.save(ad2);
		
		assertThat(expected).isNotNull();
		assertThat(ad2).isEqualTo(expected);
	}

	@Test
	void testDelete() {
		Adresse ad2 = new Adresse(2l,"street2", "city2");
		when(adresseService.delete(ad2.getId())).thenReturn(ad2);
		
		Adresse expected = controller.delete(ad2.getId());
		
		assertThat(expected).isNotNull();
		assertThat(ad2).isEqualTo(expected);
		
	}

}
