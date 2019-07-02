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

import com.joseway.ngspringsec.model.Categorie;
import com.joseway.ngspringsec.model.Contribution;
import com.joseway.ngspringsec.model.Don;
import com.joseway.ngspringsec.model.News;
import com.joseway.ngspringsec.model.Project;
import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.services.ProjectService;

@SpringBootTest
class ProjectControllerApiTest {
	
	@InjectMocks
	private ProjectControllerApi controller;
	
	@Mock
	private ProjectService projectService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		Project pro = new Project();
		pro.setId(1l);
		pro.setTitre("pro");
		pro.setDescription("descr");
		pro.setMontantSouhait(15.0);
		pro.setMontantRecu(0.0);
		pro.setImg("url");
		pro.setStatus("actif");
		pro.setUser(new User());
		pro.setCategorie(new Categorie());
		pro.getContrepartie().add(new Contribution());
		pro.getContributeurs().add(new User());
		pro.getDons().add(new Don());
		pro.getNews().add(new News());
		
		when(projectService.findById(pro.getId())).thenReturn(pro);
		
		Project expected = controller.findById(pro.getId());
		
		assertThat(expected).isNotNull();
		assertThat(pro.getId()).isEqualTo(expected.getId());
		assertThat(pro.getTitre()).isEqualTo(expected.getTitre());
		assertThat(pro.getDescription()).isEqualTo(expected.getDescription());
		assertThat(pro.getMontantSouhait()).isEqualTo(expected.getMontantSouhait());
		assertThat(pro.getMontantRecu()).isEqualTo(expected.getMontantRecu());
		assertThat(pro.getImg()).isEqualTo(expected.getImg());
		assertThat(pro.getStatus()).isEqualTo(expected.getStatus());
		assertThat(pro.getUser()).isEqualTo(expected.getUser());
		assertThat(pro.getCategorie()).isEqualTo(expected.getCategorie());
		
		assertThat(pro.getContrepartie()).isEqualTo(expected.getContrepartie());
		assertThat(pro.getContributeurs()).isEqualTo(expected.getContributeurs());
		assertThat(pro.getDons()).isEqualTo(expected.getDons());
		assertThat(pro.getNews()).isEqualTo(expected.getNews());
		
	}

	@Test
	void testFindAll() {
		Project p1 = new Project(1l, "pro", "descr", 15.0, 0.0, "url", "actif");
		Project p2 = new Project(2l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		List<Project> projects = new ArrayList<Project>();
		projects.add(p1);projects.add(p2);
		
		when(projectService.findAll()).thenReturn(projects);
		
		List<Project> expected = controller.findAll();
		
		assertThat(expected).isNotNull();
		assertThat(expected.size()).isEqualTo(2);
		assertThat(projects).isEqualTo(expected);

	}

	@Test
	void testSave() {
		Project p2 = new Project(2l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		when(projectService.save(p2)).thenReturn(p2);
		
		Project expected = controller.save(p2);
		
		assertThat(expected).isNotNull();
		assertThat(p2).isEqualTo(expected);
	}

	@Test
	void testDeleteById() {
		Project p2 = new Project(2l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		when(projectService.delete(p2.getId())).thenReturn(p2);
		
		Project expected = controller.deleteById(p2.getId());
		
		assertThat(expected).isNotNull();
		assertThat(p2).isEqualTo(expected);
	}
	
	@Test
	void testOrderBy() {
		Project p1 = new Project(1l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		Project p2 = new Project(2l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		p1.setUser(new User(1l, "Cook", "Tim", "descr","url","tim","tim@cook.fr","password"));
		p2.setUser(new User(1l, "Cook", "Tim", "descr","url","tim","tim@cook.fr","password"));
		List<Project> projects = new ArrayList<Project>();
		projects.add(p1); projects.add(p2);
		
		when(projectService.findAllByOrderByIdDesc()).thenReturn(projects);
		
		List<Project> expected = controller.OrderBy();
		
		assertThat(expected).isNotNull();
	}
	
	@Test
	void testFindAllByUser() {
		Project p1 = new Project(1l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		Project p2 = new Project(2l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		p1.setUser(new User(1l, "Cook", "Tim", "descr","url","tim","tim@cook.fr","password"));
		p2.setUser(new User(1l, "Cook", "Tim", "descr","url","tim","tim@cook.fr","password"));
		List<Project> projects = new ArrayList<Project>();
		projects.add(p1); projects.add(p2);
		when(projectService.findByUserId(p2.getUser().getId())).thenReturn(projects);
		
		List<Project> expected = controller.findAllByUser(p2.getUser().getId());
		
		assertThat(expected).isNotNull();
		assertThat(projects).isEqualTo(expected);
	}
	
	@Test
	void testFindByTitre() {
		Project p1 = new Project(1l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		Project p2 = new Project(2l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		p1.setUser(new User(1l, "Cook", "Tim", "descr","url","tim","tim@cook.fr","password"));
		p2.setUser(new User(1l, "Cook", "Tim", "descr","url","tim","tim@cook.fr","password"));
		List<Project> projects = new ArrayList<Project>();
		projects.add(p1); projects.add(p2);
		
		when(projectService.findByTitreContaining("pr")).thenReturn(projects);
		
		List<Project> expected = controller.findByTitre("pr");
		
		assertThat(expected).isNotNull();
		assertThat(projects).isEqualTo(expected);
	}
	
	@Test
	void testFindByCategorie() {
		Project p1 = new Project(1l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		Project p2 = new Project(2l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		p1.setCategorie(new Categorie(1l, "titre"));
		p2.setCategorie(new Categorie(1l, "titre"));
		List<Project> projects = new ArrayList<Project>();
		projects.add(p1); projects.add(p2);
		
		when(projectService.findByCategorieTitre("titre")).thenReturn(projects);
		
		List<Project> expected = controller.findByCategorie("titre");
		
		assertThat(expected).isNotNull();
		assertThat(projects).isEqualTo(expected);
	}
	
	@Test
	void testFindByNews() {
		Project p1 = new Project(1l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		p1.getNews().add(new News(1l, "news1", "une news", Date.valueOf(LocalDate.of(2019, 06, 19))));

		
		when(projectService.findByNewsId(1l)).thenReturn(p1);
		
		Project expected = controller.findByNews(1l);
		
		assertThat(expected).isNotNull();
		assertThat(p1).isEqualTo(expected);
	}
	
	@Test
	void testFindByContrepartie() {
		Project p1 = new Project(1l, "pr2", "desc2", 150.0, 0.0, "url2", "actif");
		Contribution contrib1 = new Contribution(1l, "titre", "description", 12.5, 4, 0, p1);
		p1.getContrepartie().add(contrib1);
		
		when(projectService.findByContrepartieId(contrib1.getId())).thenReturn(p1);
		
		Project expected = controller.findByContrepartie(contrib1.getId());
		
		assertThat(expected).isNotNull();
		assertThat(p1).isEqualTo(expected);
	}

}
