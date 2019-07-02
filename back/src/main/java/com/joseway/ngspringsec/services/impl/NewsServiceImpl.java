package com.joseway.ngspringsec.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.News;
import com.joseway.ngspringsec.repository.NewsRepository;
import com.joseway.ngspringsec.services.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsRepository newsRepository;

	@Override
	public List<News> findAll() {
		return newsRepository.findAll();
	}

	@Override
	public News save(News news) {
		return newsRepository.save(news);
	}

	@Override
	public News findById(long id) {
		return newsRepository.findById(id).get();
	}

	@Override
	public News delete(long id) {
		News news = findById(id);
		newsRepository.deleteById(id);
		return news;
	}

}
