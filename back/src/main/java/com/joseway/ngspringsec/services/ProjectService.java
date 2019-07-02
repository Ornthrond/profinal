package com.joseway.ngspringsec.services;

import java.util.List;

import com.joseway.ngspringsec.model.Project;


public interface ProjectService {

	public List<Project> findAll();
	public Project save(Project project);
	public Project findById(long id);
	public List<Project> findByTitreContaining(String titre);
	public List<Project> findByCategorieTitre(String categorie);
	public Project delete(long id);
	public List<Project> findAllByOrderByIdDesc();
	public List<Project> findByUserId(Long id);
	public Project findByNewsId(Long id);
	public Project findByContrepartieId(Long id);
}
