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
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezvous;

@RestController

public class RendezvousController {
	

	@Autowired
    IRendezvous rendezvousservice;

	@PostMapping("/rendezvous")
    public ResponseEntity<Rendezvous> save(@RequestBody Rendezvous rendezvous) {	
		  System.out.println("*******save ***********");
		   return new ResponseEntity<>(rendezvousservice.saveRendezvous(rendezvous),HttpStatus.CREATED);
 }
	@GetMapping("/api/rendezvous")
    public ResponseEntity<List<Rendezvous>> getRendezvous(){	
    System.out.println("*******affiche ***********");
    return new ResponseEntity<>(rendezvousservice.getListRendezvous(),HttpStatus.OK);

}
	

	@GetMapping("/api/rendezvous/{id}")
	Rendezvous getRendezvousById(@PathVariable Long id) {
  System.out.println("*******affiche par id ***********");
  return rendezvousservice.getRendezvous(id);
    }


	
   @DeleteMapping("/api/deleter/{id}")
    boolean delete(@PathVariable Long id) {
    rendezvousservice.deleteRendezvous(id);
    System.out.println("*******supprimer par id ***********");

        return true;
    }

@PutMapping("/api/updater")
public Rendezvous updateRendezvous(@RequestBody Rendezvous rendezvous) {
	 System.out.println("*******update***********");
	return rendezvousservice.updateRendezvous(rendezvous);
    
}


}
