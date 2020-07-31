/**
 * 
 */
package dev.service;

import java.time.LocalDate;
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
	
	public Optional<List<Collegue>> getListMatricules(String nom) throws Exception {
		Optional<List<Collegue>> c = collegueRepository.findByName(nom);
		return c;
	}
	
	public Collegue getByMatricule(String mat) throws Exception {
		Collegue c = collegueRepository.findByMatricule(mat);
		return c;
	}
	
	public Collegue creer(String nom, String prenoms, String email, LocalDate dateNaissance, String photoUrl) {
		Collegue col = new Collegue(nom, prenoms, email, dateNaissance, photoUrl);
		
		Collegue collegueSave = this.collegueRepository.save(col);
		
		return collegueSave;
	}
	
}
