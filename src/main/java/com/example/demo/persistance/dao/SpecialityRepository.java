package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistance.entities.Speciality;

public interface SpecialityRepository extends JpaRepository < Speciality , Long >{
	Speciality findByspecialityName(String nom);

}
