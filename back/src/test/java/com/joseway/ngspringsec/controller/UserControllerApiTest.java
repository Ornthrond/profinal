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
import com.joseway.ngspringsec.model.Contribution;
import com.joseway.ngspringsec.model.Don;
import com.joseway.ngspringsec.model.Project;
import com.joseway.ngspringsec.model.Role;
import com.joseway.ngspringsec.model.User;
import com.joseway.ngspringsec.services.UserService;

@SpringBootTest
class UserControllerApiTest {
	
	@InjectMocks
	private UserControllerApi controller;
	
	@Mock
	private UserService userService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		User u1 = new User();
		u1.setId(1l);
		u1.setName("Cook");
		u1.setPrenom("tim");
		u1.setDescription("ma description");
		u1.setAvatar("url");
		u1.setUsername("tim");
		u1.setEmail("tim@cook.fr");
		u1.setPassword("password");
		u1.setAdresse(new Adresse());
		
		u1.getContributions().add(new Contribution());
		u1.getDons().add(new Don());
		u1.getProject_contri().add(new Project());
		u1.getProjects().add(new Project());
		u1.getRoles().add(new Role());
		
		when(userService.findById(u1.getId())).thenReturn(u1);
		
		User expected = controller.findById(u1.getId());
		
		assertThat(expected).isNotNull();
		assertThat(u1).isEqualTo(expected);
		assertThat(u1.getId()).isEqualTo(expected.getId());
		assertThat(u1.getName()).isEqualTo(expected.getName());
		assertThat(u1.getPrenom()).isEqualTo(expected.getPrenom());
		assertThat(u1.getDescription()).isEqualTo(expected.getDescription());
		assertThat(u1.getAvatar()).isEqualTo(expected.getAvatar());
		assertThat(u1.getUsername()).isEqualTo(expected.getUsername());
		assertThat(u1.getEmail()).isEqualTo(expected.getEmail());
		assertThat(u1.getPassword()).isEqualTo(expected.getPassword());
		assertThat(u1.getContributions()).isEqualTo(expected.getContributions());
		assertThat(u1.getDons()).isEqualTo(expected.getDons());
		assertThat(u1.getProject_contri()).isEqualTo(expected.getProject_contri());
		assertThat(u1.getProjects()).isEqualTo(expected.getProjects());
		assertThat(u1.getRoles()).isEqualTo(expected.getRoles());
	}

	@Test
	void testFindAll() {
		User u1 = new User(1l, "Cook", "Tim", "descr","url","tim","tim@cook.fr","password");
		User u2 = new User(2l, "Coo2", "Ti2", "desc2","ur2","ti2","ti2@cook.fr","password");
		User u3 = new User("name", "username", "u@u.fr", "password");
		Adresse a1 = new Adresse();
		a1.setId(1l);
		a1.setStreet("street");
		a1.setCity("city");
		u1.setAdresse(a1);
		Adresse a2 = new Adresse();
		a2.setId(a1.getId()+1);
		a2.setStreet(a1.getStreet());
		a2.setCity(a1.getCity());
		List<User> users = new ArrayList<User>();
		users.add(u1); users.add(u2); users.add(u3);
		
		when(userService.findAll()).thenReturn(users);
		
		List<User> expected = controller.findAll();
		
		assertThat(expected).isNotNull();
		assertThat(expected.size()).isEqualTo(3);
		assertThat(users).isEqualTo(expected);
	}

	@Test
	void testSave() {
		User u2 = new User(2l, "Coo2", "Ti2", "desc2","ur2","ti2","ti2@cook.fr","password");
		when(userService.save(u2)).thenReturn(u2);
		
		User expected = controller.save(u2);
		
		assertThat(expected).isNotNull();
		assertThat(u2).isEqualTo(expected);
	}



}
