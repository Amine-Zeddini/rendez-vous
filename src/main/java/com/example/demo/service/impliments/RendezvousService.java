package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.RendezvousRepository;
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezvous;

@Service
public class RendezvousService implements IRendezvous {

	@Autowired
	RendezvousRepository rendezvousrepository;
	
	public Rendezvous saveRendezvous(Rendezvous rendezvous) {
		// TODO Auto-generated method stub
		return rendezvousrepository.save(rendezvous);
	}
	public Rendezvous getRendezvous(Long id) {
		// TODO Auto-generated method stub
		return rendezvousrepository.findById(id).get();
	}

	public boolean deleteRendezvous(Long id) {
		// TODO Auto-generated method stub
		 rendezvousrepository.deleteById(id);
		return true;
	}
	public Rendezvous updateRendezvous(Rendezvous rendezvous) {
		Rendezvous existingRendezvous = rendezvousrepository.findById(rendezvous.getId()).orElse(rendezvous);
		   
	    existingRendezvous.setId(rendezvous.getId());
	    existingRendezvous.setDateRDV(rendezvous.getDateRDV());
	    existingRendezvous.setHeureRDV(rendezvous.getHeureRDV());

		return rendezvousrepository.save(existingRendezvous);
		
	}
	public List<Rendezvous> getListRendezvous() {
		// TODO Auto-generated method stub
		return  rendezvousrepository.findAll();
	}
}
