package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistance.entities.Consultation;

public interface ConsultationRepository extends  JpaRepository <Consultation , Long>{

}
