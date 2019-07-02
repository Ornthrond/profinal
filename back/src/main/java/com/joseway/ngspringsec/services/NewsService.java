package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.News;


public interface NewsService {
	
	public List<News> findAll();
	public News save(News news);
	public News findById(long id);
	public News delete(long id);

}
