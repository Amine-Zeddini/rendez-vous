package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	IPatient patientservice;
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    Patient save(@RequestBody Patient patient) {	
		  System.out.println("*******save ***********");
		  Patient p=patientservice.savePatient(patient);
		  System.out.println("*******"+p.getEmail());
        return p ;
    }
	
	
	@GetMapping("/{id}")
    Patient getPatientById(@PathVariable Long id) {
        return patientservice.getPatient(id);
    }
	
	@GetMapping("/quantity")
    int getQuantityPatient() {
        return patientservice.getQuantityOfPatient();
    }
	
	@GetMapping("/patientByName/{name}")
    Patient getPatientByName(@PathVariable String name) {
        return patientservice.findPatientByName(name);
    }
	
	@DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable Long id) {
        patientservice.deletePatient(id);
        return true;
    }
	
	
	
}
