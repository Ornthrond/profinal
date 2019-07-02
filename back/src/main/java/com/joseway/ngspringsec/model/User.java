package com.joseway.ngspringsec.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;
    
	private String prenom;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="adresse_id")
	private Adresse adresse;

	private String description = "";
	private String avatar= "http://deveniracteur.fr/wp-content/uploads/2015/09/Jouer-un-personnage-ou-rester-soi-m%C3%AAme-300x300.jpg";
	
	@JsonIgnore
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<Project> projects = new HashSet<Project>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="contributeurs")
	private Set<Project> project_contri = new HashSet<Project>();
	
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinColumn(name="user_id")
	private List<Contribution> contributions = new ArrayList<Contribution>();
    
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Don> dons = new HashSet<Don>();
	
	@NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Project> getProject_contri() {
		return project_contri;
	}

	public List<Contribution> getContributions() {
		return contributions;
	}

	public Set<Don> getDons() {
		return dons;
	}



	public User(Long id, @NotBlank @Size(min = 3, max = 50) String name, String prenom, String description,
			String avatar, @NotBlank @Size(min = 3, max = 50) String username,
			@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(min = 6, max = 100) String password) {
		super();
		this.id = id;
		this.name = name;
		this.prenom = prenom;
		this.description = description;
		this.avatar = avatar;
		this.username = username;
		this.email = email;
		this.password = password;
	}
    
    
}