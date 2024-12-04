package com.example.demo.service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Speciality;
import com.example.demo.service.interfaces.ISpeciality;

@RestController
public class SpecialityController {
	

    ISpeciality specialityservice;

	@PostMapping("/speciality")
    public ResponseEntity<Speciality> save(@RequestBody Speciality speciality) {	
		  System.out.println("*******save ***********");
		   return new ResponseEntity<>(specialityservice.saveSpeciality(speciality),HttpStatus.CREATED);
 }
	@GetMapping("/api/speciality")
    public ResponseEntity<List<Speciality>> getSpeciality(){	
    System.out.println("*******affiche ***********");
    return new ResponseEntity<>(specialityservice.getListSpeciality(),HttpStatus.OK);

}
	

	@GetMapping("/api/speciality/{id}")
	Speciality getSpecialityById(@PathVariable Long id) {
  System.out.println("*******affiche par id ***********");
  return specialityservice.getSpeciality(id);
    }


	
   @DeleteMapping("/api/deletes/{id}")
    boolean delete(@PathVariable Long id) {
    specialityservice.deleteSpeciality(id);
    System.out.println("*******supprimer par id ***********");

        return true;
    }

@PutMapping("/api/updates")
public Speciality updateRendezvous(@RequestBody Speciality speciality) {
	 System.out.println("*******update***********");
	return specialityservice.updateSpeciality(speciality);
    
}
@GetMapping("/specialityByName/{name}")
Speciality findSpecialityByspecialityName(@PathVariable String name) {
    return specialityservice.findSpecialityByspecialityName(name);
}



}
