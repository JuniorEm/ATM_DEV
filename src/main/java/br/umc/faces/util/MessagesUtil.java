package br.umc.faces.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public final class MessagesUtil {
	
	public static void displayErrorMessage(final String summary, final String body) {
		FacesUtil.getFacesContext().addMessage(null, getFacesMessage(FacesMessage.SEVERITY_ERROR, summary, body));
	}
	
	public static void displayWarningMessage(final String summary, final String body) {
		FacesUtil.getFacesContext().addMessage(null, getFacesMessage(FacesMessage.SEVERITY_WARN, summary, body));
	}
	
	public static void displayInfoMessage(final String summary, final String body) {
		FacesUtil.getFacesContext().addMessage(null, getFacesMessage(FacesMessage.SEVERITY_INFO, summary, body));
	}
	
	private static FacesMessage getFacesMessage(final Severity severity, final String summary, final String body) {
		return new FacesMessage(severity, summary, body);
	}
}
