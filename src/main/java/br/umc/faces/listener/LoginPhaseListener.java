package br.umc.faces.listener;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.inject.Inject;

import org.apache.deltaspike.jsf.api.listener.phase.AfterPhase;
import org.apache.deltaspike.jsf.api.listener.phase.JsfPhaseId;
import org.apache.deltaspike.jsf.api.listener.phase.JsfPhaseListener;

import br.umc.data.entity.Account;
import br.umc.qualifier.AccountLogged;

@JsfPhaseListener
public class LoginPhaseListener {
	
	@Inject @AccountLogged private String logged;
	final List<String> listed = Arrays.asList("login.xhtml", "error.xhtml");
	
	public void listen(@Observes @AfterPhase(JsfPhaseId.RESTORE_VIEW) PhaseEvent event) {
		final FacesContext context = event.getFacesContext();
		final String page = context.getViewRoot().getViewId().replace("/", "");
		
		if (!listed.contains(page) && logged == null) {
			final NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, listed.get(0).toString().concat("?faces-redirect=true"));
		}
	}


}
