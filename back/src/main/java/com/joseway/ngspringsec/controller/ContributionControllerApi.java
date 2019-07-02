package com.joseway.ngspringsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.Contribution;
import com.joseway.ngspringsec.services.ContributionService;

@RestController
@RequestMapping(value="/api/contributions")
public class ContributionControllerApi {

	@Autowired
	private ContributionService contributionService;
	
	@GetMapping(value="/{id}")
	public Contribution findById(@PathVariable("id")Long id) {
		return contributionService.findById(id);
	}
	
	@GetMapping(value="")
	public List<Contribution> findAll(){
		return contributionService.findAll();
	}
	
	@PostMapping(value="")
	public Contribution save(@RequestBody Contribution contribution) {	
		return contributionService.save(contribution);	
	}
	
	@GetMapping(value="/delete/{id}")
	public Contribution deleteById(@PathVariable("id")Long id) {
		return contributionService.delete(id);
	}
}
