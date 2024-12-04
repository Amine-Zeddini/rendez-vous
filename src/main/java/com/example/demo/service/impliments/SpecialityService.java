package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.SpecialityRepository;
import com.example.demo.persistance.entities.Speciality;

@Service
public class SpecialityService {

	@Autowired
	SpecialityRepository specialityrepository;
	
	public Speciality saveSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return specialityrepository.save(speciality);
	}
	public Speciality getSpeciality(Long id) {
		// TODO Auto-generated method stub
		return specialityrepository.findById(id).get();
	}

	public boolean deleteSpeciality(Long id) {
		// TODO Auto-generated method stub
		 specialityrepository.deleteById(id);
		return true;
	}
	public Speciality updateSpeciality(Speciality speciality) {
		Speciality existingSpeciality = specialityrepository.findById(speciality.getId()).orElse(speciality);
		   
	    existingSpeciality.setId(speciality.getId());
	    existingSpeciality.setSpecialityName(speciality.getSpecialityName());
	    existingSpeciality.setMedecins(speciality.getMedecins());
		return specialityrepository.save(existingSpeciality);
		
	}
	public List<Speciality> getListSpeciality() {
		// TODO Auto-generated method stub
		return  specialityrepository.findAll();
	}



	public Speciality findSpecialityByspecialityName(String nom) {
		// TODO Auto-generated method stub
		return  specialityrepository.findByspecialityName(nom);
	}
	
	
}
