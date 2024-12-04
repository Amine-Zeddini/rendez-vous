package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.ConsultationRepository;
import com.example.demo.persistance.entities.Consultation;
import com.example.demo.service.interfaces.IConsultation;

@Service
public class ConsultationService implements IConsultation{
	

	@Autowired
	ConsultationRepository consultationrepository;
	
	public Consultation saveConsultation(Consultation consultation) {
		// TODO Auto-generated method stub
		return consultationrepository.save(consultation);
	}
	public Consultation getConsultation(Long id) {
		// TODO Auto-generated method stub
		return  consultationrepository.findById(id).get();
	}

	public boolean deleteConsultation(Long id) {
		// TODO Auto-generated method stub
		 consultationrepository.deleteById(id);
		return true;
	}
	public Consultation updateConsultation(Consultation consultation) {
		Consultation existingConsultation = consultationrepository.findById(consultation.getId()).orElse(consultation);
		   
	    existingConsultation.setId(consultation.getId());
	    existingConsultation.setDateConsultation(consultation.getDateConsultation());
	    existingConsultation.setRapportConsult(consultation.getRapportConsult());

		return consultationrepository.save(existingConsultation);
		
	}
	public List<Consultation> getListMedecin() {
		// TODO Auto-generated method stub
		return  consultationrepository.findAll();
	}
	@Override
	public List<Consultation> getListConsultation() {
		// TODO Auto-generated method stub
		return null;
	}


}
