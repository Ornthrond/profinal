package com.joseway.ngspringsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.Don;
import com.joseway.ngspringsec.services.DonService;

@RestController
@RequestMapping(value="/api/dons")
public class DonControllerApi {

	@Autowired
	private DonService donService;
	
	@GetMapping(value="/{id}")
	public Don findById(@PathVariable("id")Long id) {
		return donService.findById(id);
	}
	
	@GetMapping(value="")
	public List<Don> findAll(){
		return donService.findAll();
	}
	
	@PostMapping(value="")
	public Don save(@RequestBody Don don) {	
		return donService.save(don);	
	}
	
	@GetMapping(value="/delete/{id}")
	public Don deleteById(@PathVariable("id")Long id) {
		return donService.delete(id);
	}
}
