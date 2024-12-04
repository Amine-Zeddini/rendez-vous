package com.example.demo.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Medecin;
import com.example.demo.service.interfaces.IMedecin;

@RestController
public class MedecinController {
	@Autowired
    IMedecin medecinservice;

	@PostMapping("/medecin")
    public ResponseEntity< Medecin > save(@RequestBody Medecin medecin) {	
		  System.out.println("*******save ***********");
		   return new ResponseEntity<>(medecinservice.saveMedecin(medecin),HttpStatus.CREATED);
 }
	@GetMapping("/api/medecin")
    public ResponseEntity<List<Medecin>> getMedecin(){	
    System.out.println("*******affiche ***********");
    return new ResponseEntity<>(medecinservice.getListMedecin(),HttpStatus.OK);
}
	

	@GetMapping("/api/medecin/{id}")
  Medecin getMedecinById(@PathVariable Long id) {
  System.out.println("*******affichepar id ***********");
  return medecinservice.getMedecin(id);
    }


	
   @DeleteMapping("/api/delete/{id}")
    boolean delete(@PathVariable Long id) {
    medecinservice.deleteMedecin(id);
    System.out.println("*******supprimer par id ***********");
    return true;
    }

  @PutMapping("/api/update")
public  Medecin updateMedecin(@RequestBody Medecin medecin) {
	 System.out.println("*******update***********");
	return medecinservice.updateMedecin(medecin);
}

}
