package br.umc.faces.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public final class FacesUtil {
	
	public static final FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public static final ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
	public static final FacesMessage getFacesMessage(final Severity severity, final String summary, final String body) {
		return new FacesMessage(severity, summary, body);
	}
}
