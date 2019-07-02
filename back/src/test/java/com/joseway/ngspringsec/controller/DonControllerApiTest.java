package com.joseway.ngspringsec.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.joseway.ngspringsec.model.Don;
import com.joseway.ngspringsec.model.Project;
import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.services.DonService;

@SpringBootTest
class DonControllerApiTest {
	
	@InjectMocks
	private DonControllerApi controller;
	
	@Mock
	private DonService donService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		Don d1 = new Don(1l, 1.0, "project 1", Date.valueOf(LocalDate.of(2019, 06, 20)));
		d1.getProject().add(new Project());
		d1.setUser(new User());
		when(donService.findById(d1.getId())).thenReturn(d1);

		Don expected = controller.findById(d1.getId());
		
		assertThat(expected).isNotNull();
		assertThat(d1).isEqualTo(expected);
		assertThat(d1.getDate()).isEqualTo(expected.getDate());
		assertThat(d1.getDescription()).isEqualTo(expected.getDescription());
		assertThat(d1.getId()).isEqualTo(expected.getId());
		assertThat(d1.getMontant()).isEqualTo(expected.getMontant());
		assertThat(d1.getProject()).isEqualTo(expected.getProject());
		assertThat(d1.getUser()).isEqualTo(expected.getUser());
	}

	@Test
	void testFindAll() {
		Don d1 = new Don(1l, 1.0, "project 1", Date.valueOf(LocalDate.of(2019, 06, 20)));
		Don d2 = new Don(2l, 10.0, "project 1", Date.valueOf(LocalDate.of(2019, 06, 19)));
		List<Don> dons = new ArrayList<Don>();
		
		dons.add(d1); dons.add(d2);
		
		when(donService.findAll()).thenReturn(dons);
		
		List<Don> expected = controller.findAll();
		
		assertThat(expected).isNotNull();
		assertThat(expected.size()).isEqualTo(2);
		assertThat(dons).isEqualTo(expected);

	}

	@Test
	void testSave() {
		Don d2 = new Don();
		d2.setId(2l);
		d2.setDescription("projet 1");
		d2.setDate(Date.valueOf(LocalDate.of(2019, 06, 19)));
		d2.setMontant(10.0);
		when(donService.save(d2)).thenReturn(d2);
		
		Don expected = controller.save(d2);
		
		assertThat(expected).isNotNull();
		assertThat(d2).isEqualTo(expected);
	}

	@Test
	void testDeleteById() {
		Don d2 = new Don(2l, 10.0, "project 1", Date.valueOf(LocalDate.of(2019, 06, 19)));
		when(donService.delete(d2.getId())).thenReturn(d2);
		
		Don expected = controller.deleteById(d2.getId());
		
		assertThat(expected).isNotNull();
		assertThat(d2).isEqualTo(expected);
	}

}
