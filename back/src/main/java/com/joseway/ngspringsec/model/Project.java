package com.joseway.ngspringsec.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String titre;
	private String description;
	private Double montantSouhait;
	private Double montantRecu = 0.0;
	private String img ="http://www.masters-france.com/annonces/img/p/fr-default-large.jpg";
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="categorie_id")
	private Categorie categorie;
	
	private String status= "En cours";
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Contribution> contrepartie = new HashSet<Contribution>();
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(cascade=CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name="contributeur_id")
	private Set<User> contributeurs = new HashSet<User>();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="project_id")
	private Set<News> news = new HashSet<News>();
	
	//@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="project_id")
	private Set<Don> dons = new HashSet<Don>();

	public Project() {}

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

	public Double getMontantSouhait() {
		return montantSouhait;
	}

	public void setMontantSouhait(Double montantSouhait) {
		this.montantSouhait = montantSouhait;
	}

	public Double getMontantRecu() {
		return montantRecu;
	}

	public void setMontantRecu(Double montantRecu) {
		this.montantRecu = montantRecu;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Contribution> getContrepartie() {
		return contrepartie;
	}

	public void setContrepartie(Set<Contribution> contrepartie) {
		this.contrepartie = contrepartie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Set<News> getNews() {
		return news;
	}



	public Set<User> getContributeurs() {
		return contributeurs;
	}



	public Set<Don> getDons() {
		return dons;
	}



	public Project(Long id, String titre, String description, Double montantSouhait, Double montantRecu, String img,
			String status) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.montantSouhait = montantSouhait;
		this.montantRecu = montantRecu;
		this.img = img;
		this.status = status;
	}

	
}
