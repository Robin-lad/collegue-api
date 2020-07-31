/**
 * 
 */
package dev.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.Collegue;
import dev.service.CollegueService;

/**
 * @author robin
 *
 */
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
		List<String> matricules = collegueService.getListMatricules(nom);
		return matricules;
	}
	
	@GetMapping("{mat}")
	public Collegue getByMatricule(@PathVariable String mat) {
		Collegue c = collegueService.getByMatricule(mat);
		return c;
	}
}
