package com.joseway.ngspringsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.Adresse;
import com.joseway.ngspringsec.services.AdresseService;

@RestController
@RequestMapping(value="/api/adresses")
public class AdresseControllerApi {
	
	@Autowired
	private AdresseService adresseService;
	
	@GetMapping(value="/{id}")
	public Adresse findById(@PathVariable("id")Long id) {
		return adresseService.findById(id);
	}
	
	@GetMapping(value="")
	public List<Adresse> findAll(){
		return adresseService.findAll();
	}
	
	@PostMapping(value="")
	public Adresse save(@RequestBody Adresse adresse){
		return adresseService.save(adresse);
	}
	
	@GetMapping(value="/delete/{id}")
	public Adresse delete(@PathVariable("id")Long id) {
		return adresseService.delete(id);
	}

}
