package com.joseway.ngspringsec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Contribution {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	private String description;
	private Double montant;
	private Integer totalPris = 0;
	private Integer nombre;
	
	@JsonIgnore
	@ManyToOne
	private Project project;
	
	@JsonIgnore
	@ManyToMany(mappedBy="contributions")
	private List<User> user = new ArrayList<User>();

	public Contribution() {}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	public Integer getTotalPris() {
		return totalPris;
	}

	public void setTotalPris(Integer totalPris) {
		this.totalPris = totalPris;
	}

	public List<User> getUser() {
		return user;
	}


	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Contribution(Long id, String titre, String description, Double montant, Integer nombre) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.montant = montant;
		this.nombre = nombre;
	}

	public Contribution(Long id, String titre, String description, Double montant, Integer totalPris, Integer nombre,
			Project project) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.montant = montant;
		this.totalPris = totalPris;
		this.nombre = nombre;
		this.project = project;
	}
	
	
	
}
