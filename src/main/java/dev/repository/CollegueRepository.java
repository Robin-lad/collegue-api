/**
 * 
 */
package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entites.Collegue;

/**
 * @author robin
 *
 */
public interface CollegueRepository extends JpaRepository<Collegue, Integer>{
	
	@Query("select c from Collegue c where c.nom = ?1")
	Optional<List<Collegue>> findByName(String nom);
}