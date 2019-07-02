package com.joseway.ngspringsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.News;
import com.joseway.ngspringsec.services.NewsService;

@RestController
@RequestMapping(value="/api/news")
public class NewsControllerApi {
	
	@Autowired
	private NewsService newsService;

	@GetMapping(value="/{id}")
	public News findById(@PathVariable("id")Long id) {
		return newsService.findById(id);
	}
	
	@GetMapping(value="")
	public List<News> findAll(){
		return newsService.findAll();
	}
	
	@PostMapping(value="")
	public News save(@RequestBody News news) {	
		return newsService.save(news);	
	}
	
	@GetMapping(value="/delete/{id}")
	public News deleteById(@PathVariable("id")Long id) {
		return newsService.delete(id);
	}
}
