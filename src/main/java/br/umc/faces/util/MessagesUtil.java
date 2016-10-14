package br.umc.faces.util;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * Classe utilitária para exibição de mensagens.
 * @author Junior
 *
 */
@RequestScoped
public class MessagesUtil {
	
	public void displayErrorMessage(final String summary, final String body) {
		addMessage(FacesMessage.SEVERITY_ERROR, summary, body);
	}
	
	public void displayWarningMessage(final String summary, final String body) {
		addMessage(FacesMessage.SEVERITY_WARN, summary, body);
	}
	
	public void displayInfoMessage(final String summary, final String body) {
		addMessage(FacesMessage.SEVERITY_INFO, summary, body);
	}
	
	private void addMessage(final Severity severity, final String summary, final String body) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, body));
	}
}
