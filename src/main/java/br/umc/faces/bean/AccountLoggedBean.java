package br.umc.faces.bean;

import static br.umc.faces.page.Page.CONSULT;
import static br.umc.faces.page.Page.LOGIN;
import static br.umc.faces.page.Page.WITHDRAW;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.umc.data.dao.AccountDAO;
import br.umc.data.entity.Account;
import br.umc.faces.util.FacesUtil;
import br.umc.qualifier.AccountLogged;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class AccountLoggedBean implements Serializable {
	private Account account;
	@Inject private AccountDAO dao;
	private String logged;

	@PostConstruct
	public void init() {

		if (logged != null)
			account = dao.findByAccountNumber(logged);
	}

	@Produces
	@AccountLogged
	public String getLogged() {
		return logged;
	}

	public void register(final Account account) {
		dao.save(account);
		this.account = account;
		this.logged = account.getAccountNumber();
	}

	public void logout() {
		FacesUtil.invalidateSession();
		FacesUtil.redirect(LOGIN.getURL());
	}

	public void redirectToConsult() {
		FacesUtil.redirect(CONSULT.getURL());
	}
	
	public void redirectToWithdraw() {
		FacesUtil.redirect(WITHDRAW.getURL());
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(final Account account) {
		this.account = account;
	}


}