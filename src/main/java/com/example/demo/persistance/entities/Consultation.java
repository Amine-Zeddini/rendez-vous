package com.example.demo.persistance.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

public class Consultation {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateConsultation;
    private String rapportConsult;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public  String getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation( String dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getRapportConsult() {
		return rapportConsult;
	}

	public void setRapportConsult(String rapportConsult) {
		this.rapportConsult = rapportConsult;
	}

	public Rendezvous getRendezvous() {
		return rendezvous;
	}

	public void setRendezvous(Rendezvous rendezvous) {
		this.rendezvous = rendezvous;
	}

	@JsonBackReference
	@OneToOne
    private Rendezvous rendezvous;

	@Override
	public String toString() {
		return "Consultation [id=" + id + ", dateConsultation=" + dateConsultation + ", rapportConsult="
				+ rapportConsult + ", rendezvous=" + rendezvous + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultation(Long id,  String dateConsultation, String rapportConsult, Rendezvous rendezvous) {
		super();
		this.id = id;
		this.dateConsultation = dateConsultation;
		this.rapportConsult = rapportConsult;
		this.rendezvous = rendezvous;
	}
	
}
