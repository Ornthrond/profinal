package com.joseway.ngspringsec.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseway.ngspringsec.model.Project;
import com.joseway.ngspringsec.repository.ProjectRepository;
import com.joseway.ngspringsec.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project findById(long id) {
		return projectRepository.findById(id).get();
	}

	@Override
	public Project delete(long id) {
		Project project = findById(id);
		projectRepository.deleteById(id);
		return project;
	}

	@Override
	public List<Project> findByTitreContaining(String titre) {
		return projectRepository.findByTitreContaining(titre);
	}

	@Override
	public List<Project> findByCategorieTitre(String categorie) {
		return projectRepository.findByCategorieTitre(categorie);
	}

	@Override
	public List<Project> findAllByOrderByIdDesc() {
		return projectRepository.findAllByOrderByIdDesc();
	}

	@Override
	public List<Project> findByUserId(Long id) {
		return projectRepository.findByUserId(id);
	}

	@Override
	public Project findByNewsId(Long id) {
		return projectRepository.findByNewsId(id);
	}

	@Override
	public Project findByContrepartieId(Long id) {
		return projectRepository.findByContrepartieId(id);
	}





}
