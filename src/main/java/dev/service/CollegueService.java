/**
 * 
 */
package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.entites.Collegue;
import dev.repository.CollegueRepository;

/**
 * @author robin
 *
 */
@Service
@Transactional
public class CollegueService {

	private CollegueRepository collegueRepository;

	public CollegueService(CollegueRepository collegueRepository) {
		super();
		this.collegueRepository = collegueRepository;
	}

	public List<Collegue> getListCollegue(){
		return collegueRepository.findAll();
	}
	
	public List<String> getListMatricules(String nom) throws Exception {
		Optional<List<Collegue>> c = collegueRepository.findByName(nom);
		List<String> list = new ArrayList<>();
		if(c.isPresent()) {
			for(Collegue col : c.get()) {
				list.add(col.getMatricule());
			}
		}
		if(c.isEmpty()) {
			throw new RuntimeException("Pas de personne de ce nom");
		}
		return list;
	}
	
	public Collegue getByMatricule(String mat) {
		Collegue c = collegueRepository.findByMatricule(mat);
		
		if(c == null) {
			throw new RuntimeException("Pas de personne ayant ce matricule");
		}
		
		return c;
	}
	
}
