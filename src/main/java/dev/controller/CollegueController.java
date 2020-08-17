/**
 * 
 */
package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.CodeErreur;
import dev.dto.CollegueDto;
import dev.dto.CreerCollegueDto;
import dev.dto.MessageErreurDto;
import dev.dto.UpdateCollegueDto;
import dev.entites.Collegue;
import dev.exception.CollegueException;
import dev.service.CollegueService;

/**
 * @author robin
 *
 */
@CrossOrigin
@RestController
@RequestMapping("collegues")
public class CollegueController {
	
	private CollegueService collegueService;

	public CollegueController(CollegueService collegueService) {
		super();
		this.collegueService = collegueService;
	}
	
	@GetMapping("test/all")
	public List<Collegue> getAllCollegues(){
		return collegueService.getListCollegue();
	}
	
	@GetMapping
	public List<String> getMatricules(@RequestParam("nom") String nom) throws Exception{
		List<Collegue> matricules = collegueService.getListMatricules(nom);
		List<String> list = new ArrayList<>();
		if(!matricules.isEmpty()) {
			for(Collegue col : matricules) {
				list.add(col.getMatricule().toString());
			}
		}
		if(matricules.isEmpty()) {
			throw new CollegueException(new MessageErreurDto(CodeErreur.VALIDATION, "Pas de personne de ce nom"));
		}
		return list;
	}
	
	@GetMapping("{mat}")
	public Collegue getByMatricule(@PathVariable UUID mat) throws Exception {
		Collegue c = collegueService.getByMatricule(mat);
		if(c == null) {
			throw new CollegueException(new MessageErreurDto(CodeErreur.VALIDATION, "Pas de personne ayant ce matricule"));
		}
		return c;
	}
	
	@PostMapping
	public CollegueDto creerCollegue(@RequestBody @Valid CreerCollegueDto collegue, BindingResult result) {
		
		if(result.hasErrors()) {
			throw new CollegueException(new MessageErreurDto(CodeErreur.VALIDATION, "Données incorrectes pour la création d'un client."));
		}
		
		Collegue collegueCreer = collegueService.creer(collegue.getNom(), collegue.getPrenoms(), collegue.getEmail(), collegue.getDateDeNaissance(), collegue.getPhotoUrl());
		
		CollegueDto collegueDto = new CollegueDto();
		collegueDto.setId(collegueCreer.getId());
		collegueDto.setMatricule(collegueCreer.getMatricule());
		collegueDto.setNom(collegueCreer.getNom());
		collegueDto.setPrenoms(collegueCreer.getPrenoms());
		collegueDto.setEmail(collegueCreer.getEmail());
		collegueDto.setDateDeNaissance(collegueCreer.getDateDeNaissance());
		collegueDto.setPhotoUrl(collegueCreer.getPhotoUrl());
		
		return collegueDto;
	}
	
	@PatchMapping
	public void updateCollegue(@RequestBody @Valid UpdateCollegueDto uCol, BindingResult result) {
		
		if(result.hasErrors()) {
			throw new CollegueException(new MessageErreurDto(CodeErreur.VALIDATION, "Données incorrectes pour la modification d'un client."));
		}
		
		collegueService.updateCol(uCol.getEmail(), uCol.getPhotoUrl(), uCol.getMatricule());
	}
}
