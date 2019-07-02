package com.joseway.ngspringsec.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	private String description;
	private Date datePubli;
	
	@JsonIgnore
	@ManyToMany(mappedBy="news")
	private Set<Project> project_news = new HashSet<Project>();
	
	public News() {}

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

	public Date getDatePubli() {
		return datePubli;
	}

	public void setDatePubli(Date datePubli) {
		this.datePubli = datePubli;
	}



	public Set<Project> getProject_news() {
		return project_news;
	}

	public void setProject_news(Set<Project> project_news) {
		this.project_news = project_news;
	}

	public News(Long id, String titre, String description, Date datePubli) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.datePubli = datePubli;
	}
	
	

}
