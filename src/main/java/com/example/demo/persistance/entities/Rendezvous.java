package com.example.demo.persistance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity

public class Rendezvous implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateRDV;
    private String heureRDV;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateRDV() {
		return dateRDV;
	}

	public void setDateRDV(String dateRDV) {
		this.dateRDV = dateRDV;
	}

	public String getHeureRDV() {
		return heureRDV;
	}

	public void setHeureRDV(String heureRDV) {
		this.heureRDV = heureRDV;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Consultation getConsult() {
		return consult;
	}

	public void setConsult(Consultation consult) {
		this.consult = consult;
	}

	public Rendezvous() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rendezvous(Long id, String dateRDV, String heureRDV, Patient patient, Medecin medecin,
			Consultation consult) {
		super();
		this.id = id;
		this.dateRDV = dateRDV;
		this.heureRDV = heureRDV;
		this.patient = patient;
		this.medecin = medecin;
		this.consult = consult;
	}

	@Override
	public String toString() {
		return "Rendezvous [id=" + id + ", dateRDV=" + dateRDV + ", heureRDV=" + heureRDV + ", patient=" + patient
				+ ", medecin=" + medecin + ", consult=" + consult + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	@JsonBackReference
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    
    @OneToOne
    private Consultation consult;
}