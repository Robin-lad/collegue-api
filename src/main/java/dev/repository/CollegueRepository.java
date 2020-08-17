/**
 * 
 */
package dev.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.entites.Collegue;

/**
 * @author robin
 *
 */
public interface CollegueRepository extends JpaRepository<Collegue, Integer>{
	
	@Query("select c from Collegue c where c.nom = ?1")
	List<Collegue> findByName(String nom);
	
	@Query("select c from Collegue c where c.matricule = ?1")
	Collegue findByMatricule(UUID mat);
	
	@Modifying
	@Query("update Collegue c set c.email = ?1, c.photoUrl = ?2 where c.matricule = ?3")
	void updateCollegue(String email, String photoUrl, UUID mat);
}
