package com.joseway.ngspringsec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseway.ngspringsec.model.Project;

public interface ProjectRepository  extends JpaRepository<Project, Long>{

	public List<Project> findByTitreContaining(String titre);
	public List<Project> findByCategorieTitre(String categorie);
	public List<Project> findAllByOrderByIdDesc();
	public List<Project> findByUserId(Long id);
	public Project findByNewsId(Long id);
	public Project findByContrepartieId(Long id);
}
