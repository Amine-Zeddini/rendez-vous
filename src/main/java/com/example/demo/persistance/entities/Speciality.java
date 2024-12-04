package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Speciality implements Serializable {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String specialityName;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getSpecialityName() {
	return specialityName;
}

public void setSpecialityName(String specialityName) {
	this.specialityName = specialityName;
}

public List<Medecin> getMedecins() {
	return medecins;
}

public void setMedecins(List<Medecin> medecins) {
	this.medecins = medecins;
}

public Speciality() {
	super();
	// TODO Auto-generated constructor stub
}

public Speciality(Long id, String specialityName, List<Medecin> medecins) {
	super();
	this.id = id;
	this.specialityName = specialityName;
	this.medecins = medecins;
}

@Override
public String toString() {
	return "Speciality [id=" + id + ", specialityName=" + specialityName + ", medecins=" + medecins + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

@JsonBackReference

@ManyToMany (fetch = FetchType.EAGER)
private List<Medecin> medecins;

	

}
