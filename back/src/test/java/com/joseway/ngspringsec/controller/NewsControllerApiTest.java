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

import com.joseway.ngspringsec.model.News;
import com.joseway.ngspringsec.services.NewsService;

@SpringBootTest
class NewsControllerApiTest {
	
	@InjectMocks
	private NewsControllerApi controller;
	
	@Mock
	private NewsService newsService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testFindById() {
		News n1 = new News();
		n1.setId(1l);
		n1.setDescription("une news");
		n1.setTitre("news1");
		n1.setDatePubli(Date.valueOf(LocalDate.of(2019, 06, 19)));
		
		when(newsService.findById(n1.getId())).thenReturn(n1);
		
		News expected = controller.findById(n1.getId());
		
		assertThat(expected).isNotNull();
		assertThat(n1).isEqualTo(expected);
		assertThat(n1.getDatePubli()).isEqualTo(expected.getDatePubli());
		assertThat(n1.getDescription()).isEqualTo(expected.getDescription());
		assertThat(n1.getTitre()).isEqualTo(expected.getTitre());
	}

	@Test
	void testFindAll() {
		News n1 = new News(1l, "news1", "une news", Date.valueOf(LocalDate.of(2019, 06, 19)));
		News n2 = new News(2l, "news2", "une new2", Date.valueOf(LocalDate.of(2019, 06, 19)));
		List<News> news = new ArrayList<News>();
		news.add(n1); news.add(n2);
		
		when(newsService.findAll()).thenReturn(news);
		
		List<News> expected = controller.findAll();
		
		assertThat(expected).isNotNull();
		assertThat(expected.size()).isEqualTo(2);
		assertThat(news).isEqualTo(expected);
	}

	@Test
	void testSave() {
		News n2 = new News(2l, "news2", "une new2", Date.valueOf(LocalDate.of(2019, 06, 19)));
		when(newsService.save(n2)).thenReturn(n2);
		
		News expected = controller.save(n2);
		
		assertThat(expected).isNotNull();
		assertThat(n2).isEqualTo(expected);
	}

	@Test
	void testDeleteById() {
		News n2 = new News(2l, "news2", "une new2", Date.valueOf(LocalDate.of(2019, 06, 19)));
		when(newsService.delete(n2.getId())).thenReturn(n2);
		
		News expected = controller.deleteById(n2.getId());
		
		assertThat(expected).isNotNull();
		assertThat(n2).isEqualTo(expected);
	}

}
