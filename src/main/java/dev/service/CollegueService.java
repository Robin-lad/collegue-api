/**
 * 
 */
package dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.dto.ListePhotos;
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

	public List<ListePhotos> getListPhotos(){
		List<Collegue> tmpCol = collegueRepository.findAll();
		
		
		List<ListePhotos> tmpPhoto = new ArrayList<>();
		
		for(Collegue c : tmpCol) {
			tmpPhoto.add(new ListePhotos(c.getMatricule(), c.getPhotoUrl()));
		}
		
		return tmpPhoto;
	}
	
	public List<Collegue> getListMatricules(String nom) throws Exception {
		List<Collegue> c = collegueRepository.findByName(nom);
		return c;
	}
	
	public Collegue getByMatricule(UUID mat) throws Exception {
		Collegue c = collegueRepository.findByMatricule(mat);
		return c;
	}

	public Collegue creer(String nom, String prenoms, String email, LocalDate dateNaissance, String photoUrl) {
		Collegue col = new Collegue(nom, prenoms, email, dateNaissance, photoUrl);
		Collegue collegueSave = this.collegueRepository.save(col);
		
		return collegueSave;
	}
	
	public void updateCol(String email, String photoUrl, UUID mat) {
		this.collegueRepository.updateCollegue(email, photoUrl, mat);
	}
	
}
