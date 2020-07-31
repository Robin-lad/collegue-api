/**
 * 
 */
package dev.dto;

import java.util.UUID;

/**
 * @author robin
 *
 */
public class CollegueDto extends CreerCollegueDto{
	
	private int id;
	private UUID matricule;

	/**
	 * Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return the matricule
	 */
	public UUID getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(UUID matricule) {
		this.matricule = matricule;
	}
	
	
}
