package com.joseway.ngspringsec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseway.ngspringsec.model.News;

public interface NewsRepository  extends JpaRepository<News, Long>{

}
