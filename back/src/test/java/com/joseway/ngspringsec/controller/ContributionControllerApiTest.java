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

import com.joseway.ngspringsec.model.Contribution;
import com.joseway.ngspringsec.model.Project;
import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.services.ContributionService;

@SpringBootTest
class ContributionControllerApiTest {
	
	@InjectMocks
	private ContributionControllerApi controller;
	
	@Mock
	private ContributionService contributionService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		Project pro = new Project();
		Contribution contrib1 = new Contribution(1l, "titre", "description", 12.5, 4, 0, pro);
		when(contributionService.findById(contrib1.getId())).thenReturn(contrib1);

		Contribution expected = controller.findById(contrib1.getId());
		
		assertThat(expected).isNotNull();
		assertThat(contrib1).isEqualTo(expected);
		assertThat(contrib1.getTotalPris()).isEqualTo(expected.getTotalPris());
		assertThat(contrib1.getProject()).isEqualTo(expected.getProject());
		assertThat(contrib1.getId()).isEqualTo(expected.getId());
		assertThat(contrib1.getDescription()).isEqualTo(expected.getDescription());
		assertThat(contrib1.getMontant()).isEqualTo(expected.getMontant());
		assertThat(contrib1.getNombre()).isEqualTo(expected.getNombre());
		assertThat(contrib1.getTitre()).isEqualTo(expected.getTitre());
		assertThat(contrib1.getTotalPris()).isEqualTo(expected.getTotalPris());
	}

	@Test
	void testFindAll() {
		Contribution contrib1 = new Contribution(1l, "titre", "description", 12.5, 4);
		Contribution contrib2 = new Contribution(2l, "titre2", "description2", 14.5, 1);
		List<Contribution> contributions = new ArrayList<Contribution>();
		contributions.add(contrib1); contributions.add(contrib2);
		
		when(contributionService.findAll()).thenReturn(contributions);
		
		List<Contribution> expected = controller.findAll();
		
		assertThat(expected).isNotNull();
		assertThat(expected.size()).isEqualTo(2);
		assertThat(contributions).isEqualTo(expected);
	}

	@Test
	void testSave() {
		Project pro = new Project();
		Contribution contrib2 = new Contribution();
		contrib2.setId(2l);
		contrib2.setTitre("titre2");
		contrib2.setDescription("description2");
		contrib2.setMontant(14.5);
		contrib2.setNombre(1);
		contrib2.setTotalPris(0);
		contrib2.setProject(pro);
		contrib2.getUser().add(new User());
		
		when(contributionService.save(contrib2)).thenReturn(contrib2);
		
		Contribution expected = controller.save(contrib2);
		
		assertThat(expected).isNotNull();
		assertThat(contrib2).isEqualTo(expected);
	}

	@Test
	void testDeleteById() {
		Contribution contrib2 = new Contribution(2l, "titre2", "description2", 14.5, 1);
		when(contributionService.delete(contrib2.getId())).thenReturn(contrib2);
		
		Contribution expected = controller.deleteById(contrib2.getId());
		
		assertThat(expected).isNotNull();
		assertThat(contrib2).isEqualTo(expected);
	}

}
