package com.joseway.ngspringsec.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.Categorie;
import com.joseway.ngspringsec.repository.CategorieRepository;
import com.joseway.ngspringsec.services.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService{
	
	@Autowired
	private CategorieRepository categoryRepository;

	@Override
	public List<Categorie> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Categorie save(Categorie categorie) {
		return categoryRepository.save(categorie);
	}

	@Override
	public Categorie findById(long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Categorie delete(long id) {
		Categorie categorie = findById(id);
		categoryRepository.deleteById(id);
		return categorie;
	}

}
