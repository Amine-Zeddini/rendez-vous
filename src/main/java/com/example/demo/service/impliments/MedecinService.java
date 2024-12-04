package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.MedecinRepository;
import com.example.demo.persistance.entities.Medecin;
import com.example.demo.service.interfaces.IMedecin;

@Service
public class MedecinService implements IMedecin {
	@Autowired
	MedecinRepository medecinrepository;
	
	public Medecin saveMedecin(Medecin medecin) {
		// TODO Auto-generated method stub
		return medecinrepository.save(medecin);
	}
	public Medecin getMedecin(Long id) {
		// TODO Auto-generated method stub
		return  medecinrepository.findById(id).get();
	}

	public boolean deleteMedecin(Long id) {
		// TODO Auto-generated method stub
		 medecinrepository.deleteById(id);
		return true;
	}
	public Medecin updateMedecin(Medecin medecin) {
		Medecin existingMedecin = medecinrepository.findById(medecin.getId()).orElse(medecin);
		   
	    existingMedecin.setId(medecin.getId());
	    existingMedecin.setNom(medecin.getNom());
	    existingMedecin.setEmail(medecin.getEmail());
		return medecinrepository.save(existingMedecin);
		
	}
	public List<Medecin> getListMedecin() {
		// TODO Auto-generated method stub
		return  medecinrepository.findAll();
	}



	public Medecin findMedecinByName(String nom) {
		// TODO Auto-generated method stub
		return  medecinrepository.findByNom(nom);
	}

}
