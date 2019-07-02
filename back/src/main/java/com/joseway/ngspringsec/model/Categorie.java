package com.joseway.ngspringsec.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	
	@JsonIgnore
	@OneToMany(mappedBy="categorie")
	private Set<Project> projects = new HashSet<Project>();
	
	public Categorie() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public Categorie(Long id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	
}
