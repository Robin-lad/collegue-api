/**
 * 
 */
package dev.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author robin
 *
 */
public class UpdateCollegueDto {
	
	@NotNull
	@NotBlank
	private UUID matricule;
	
	@NotNull
	@Size(min = 7)
	@NotBlank
	private String photoUrl;
	
	@NotNull
	@Size(min = 3)
	@NotBlank
	private String email;

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

	/**
	 * Getter
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * Setter
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
