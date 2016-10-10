package br.umc.faces.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.umc.data.entity.Account;
import br.umc.faces.model.Consult;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class ConsultBean implements Serializable {
	@Inject private AccountLoggedBean logged;
	private Consult consult;
	
	@PostConstruct
	public void init() {
		final Account account = logged.getAccount();
		consult = new Consult();
		consult.extract(account);
	}
	
	public Consult getConsult() {
		return consult;
	}
}
