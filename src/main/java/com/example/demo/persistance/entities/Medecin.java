package com.example.demo.persistance.entities;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

@Entity
public class Medecin implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
   
    @Override
	public String toString() {
		return "Medecin [id=" + id + ", nom=" + nom + ", email=" + email + ", Listrdv=" + Listrdv + ", specialities="
				+ specialities + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecin(Long id, String nom, String email, List<Rendezvous> listrdv, List<Speciality> specialities) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.Listrdv = listrdv;
		this.specialities = specialities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Rendezvous> getListrdv() {
		return Listrdv;
	}

	public void setListrdv(List<Rendezvous> listrdv) {
		Listrdv = listrdv;
	}

	public List<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
	}

	@JsonBackReference
    @OneToMany(mappedBy = "medecin")
    private List<Rendezvous> Listrdv;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Speciality> specialities;
  
}