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

import com.example.demo.persistance.entities.Consultation;
import com.example.demo.service.interfaces.IConsultation;

@RestController
public class ConsultationController {

	@Autowired
    IConsultation consultationservice;

	@PostMapping("/consultation")
    public ResponseEntity<Consultation > save(@RequestBody Consultation consultation ) {	
		  System.out.println("*******save ***********");
		   return new ResponseEntity<>(consultationservice.saveConsultation(consultation),HttpStatus.CREATED);
 }
	@GetMapping("/api/consultation")
    public ResponseEntity<List<Consultation>> getConsultation(){	
    System.out.println("*******affiche ***********");
    return new ResponseEntity<>(consultationservice.getListConsultation(),HttpStatus.OK);

}
	

	@GetMapping("/api/consultation/{id}")
  Consultation getConsultationById(@PathVariable Long id) {
  System.out.println("*******affiche par id ***********");
  return consultationservice.getConsultation(id);
    }


	
   @DeleteMapping("/api/deletec/{id}")
    boolean delete(@PathVariable Long id) {
    consultationservice.deleteConsultation(id);
    System.out.println("*******supprimer par id ***********");

        return true;
    }

@PutMapping("/api/updatec")
public  Consultation updateConsultation(@RequestBody Consultation consultation) {
	 System.out.println("*******update***********");
	return consultationservice.updateConsultation(consultation);
    
}


}
