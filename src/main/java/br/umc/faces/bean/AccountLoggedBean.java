package br.umc.faces.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import br.umc.data.entity.Account;
import br.umc.qualifier.AccountLogged;

@Named
@SessionScoped
public class AccountLoggedBean implements Serializable {
	private Account account;
	private String logged;
	
	@PostConstruct
	public void init() {
		
	}
	
	@Produces @AccountLogged
	public String getLogged() {
		return logged;
	}
	
	public String getMessage() {
		return "Seja bem vindo!";
	}
	
	public void register(final String logged) {
		this.logged = logged;
	}
}
