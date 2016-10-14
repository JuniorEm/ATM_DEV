package br.umc.faces.util;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public final class FacesUtil {

	public static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public static void redirect(final String page) throws IOException {
			final ExternalContext externalContext = getExternalContext();
			externalContext.redirect(page);
	}

	public static void invalidateSession() {
		getExternalContext().invalidateSession();
	}
}
