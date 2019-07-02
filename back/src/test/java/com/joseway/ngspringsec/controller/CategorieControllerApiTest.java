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

import com.joseway.ngspringsec.model.Categorie;
import com.joseway.ngspringsec.model.Project;
import com.joseway.ngspringsec.services.CategorieService;

@SpringBootTest
class CategorieControllerApiTest {
	
	@InjectMocks
	private CategorieControllerApi controller;
	
	@Mock
	private CategorieService categorieService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		Categorie cat1 = new Categorie(1l,"Technologie");
		Project projects = new Project();
		cat1.getProjects().add(projects);
		when(categorieService.findById(cat1.getId())).thenReturn(cat1);
		
		Categorie expected = controller.findById(cat1.getId());
		
		assertThat(expected).isNotNull();
		assertThat(cat1).isEqualTo(expected);
		assertThat(cat1.getId()).isEqualTo(expected.getId());
		assertThat(cat1.getProjects()).isEqualTo(expected.getProjects());
		assertThat(cat1.getTitre()).isEqualTo(expected.getTitre());
		assertThat(cat1.getProjects()).isEqualTo(expected.getProjects());
	}

	@Test
	void testFindAll() {
		Categorie cat1 = new Categorie(1l,"Technologie");
		Categorie cat2 = new Categorie(2l,"Jeux");
		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(cat1); categories.add(cat2);
		
		when(categorieService.findAll()).thenReturn(categories);
		
		List<Categorie> expected = controller.findAll();
		
		assertThat(expected).isNotNull();
		assertThat(expected.size()).isEqualTo(2);
		assertThat(categories).isEqualTo(expected);
		
	}

	@Test
	void testSave() {
		Categorie cat2 = new Categorie();
		cat2.setId(2l); cat2.setTitre("Jeux");
		when(categorieService.save(cat2)).thenReturn(cat2);
		
		Categorie expected = controller.save(cat2);
		
		assertThat(expected).isNotNull();
		assertThat(cat2).isEqualTo(expected);
	}

	@Test
	void testDeleteById() {
		Categorie cat2 = new Categorie(2l,"Jeux");		
		when(categorieService.delete(cat2.getId())).thenReturn(cat2);
		
		Categorie expected = controller.deleteById(cat2.getId());
		
		assertThat(expected).isNotNull();
		assertThat(cat2).isEqualTo(expected);
	}

}
