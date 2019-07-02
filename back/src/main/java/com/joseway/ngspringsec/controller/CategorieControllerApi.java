package com.joseway.ngspringsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.Categorie;
import com.joseway.ngspringsec.services.CategorieService;


@RestController
@RequestMapping(value="/api/categories")
public class CategorieControllerApi {
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping(value="/{id}")
	public Categorie findById(@PathVariable("id")Long id) {
		return categorieService.findById(id);
	}
	
	@GetMapping(value="")
	public List<Categorie> findAll(){
		return categorieService.findAll();
	}
	
	@PostMapping(value="")
	public Categorie save(@RequestBody Categorie categorie) {	
		return categorieService.save(categorie);	
	}
	
	@GetMapping(value="/delete/{id}")
	public Categorie deleteById(@PathVariable("id")Long id) {
		return categorieService.delete(id);
	}

}
