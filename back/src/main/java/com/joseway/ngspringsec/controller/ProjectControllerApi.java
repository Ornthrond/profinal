package com.joseway.ngspringsec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseway.ngspringsec.model.Project;
import com.joseway.ngspringsec.services.ProjectService;

@RestController
@RequestMapping(value="/api/projects")
public class ProjectControllerApi {
	
	@Autowired
	private ProjectService projectService;

	
	@GetMapping(value="/{id}")
	public Project findById(@PathVariable("id")Long id) {
		return projectService.findById(id);
	}
	
	@GetMapping(value="")
	public List<Project> findAll(){
		return projectService.findAll();
	}
	
	@PostMapping(value="")
	public Project save(@RequestBody Project project) {	
		return projectService.save(project);	
	}
	
	@GetMapping(value="/delete/{id}")
	public Project deleteById(@PathVariable("id")Long id) {
		return projectService.delete(id);
	}
	
	@GetMapping(value="/order")
	public List<Project> OrderBy(){
		return projectService.findAllByOrderByIdDesc();
		
	}
	
	@GetMapping(value="/user/{id}")
	public List<Project> findAllByUser(@PathVariable("id")Long id){
		return projectService.findByUserId(id);
	}
	
	@GetMapping(value="/titre/{titre}")
	public List<Project> findByTitre(@PathVariable("titre")String titre){
		return projectService.findByTitreContaining(titre);
	}

	@GetMapping(value="/categorie/{categorie}")
	public List<Project> findByCategorie(@PathVariable("categorie")String categorie){
		return projectService.findByCategorieTitre(categorie);
	}
	
	@GetMapping(value="/news/{id}")
	public Project findByNews(@PathVariable("id")Long id) {
		return projectService.findByNewsId(id);
	}
	
	@GetMapping(value="/contrepartie/{id}")
	public Project findByContrepartie(@PathVariable("id")Long id) {
		return projectService.findByContrepartieId(id);
	}
}
