/**
 * 
 */
package dev.exception;

import dev.dto.MessageErreurDto;

/**
 * @author robin
 *
 */
public class CollegueException extends RuntimeException {

	private MessageErreurDto messageErreur;

	public CollegueException(MessageErreurDto messageErreur) {
		super(messageErreur.getMessage());
		this.messageErreur = messageErreur;
	}

	/**
	 * Getter
	 * @return the messageErreur
	 */
	public MessageErreurDto getMessageErreur() {
		return messageErreur;
	}
}
