package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistance.entities.Medecin;

public interface MedecinRepository extends JpaRepository <Medecin , Long>{
	Medecin findByNom(String nom);
}
