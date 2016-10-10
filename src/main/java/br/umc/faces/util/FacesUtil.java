package br.umc.faces.util;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public final class FacesUtil {
	
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public static RequestContext getRequestContext() {
		return RequestContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	public static void redirect(final String page) {
		try {
			final ExternalContext externalContext = getExternalContext();
			externalContext.redirect(page);
		} catch (final IOException e) {
			MessagesUtil.displayErrorMessage("Error", e.getMessage());
		}
	}

	public static void invalidateSession() {
		getExternalContext().invalidateSession();
	}

}
