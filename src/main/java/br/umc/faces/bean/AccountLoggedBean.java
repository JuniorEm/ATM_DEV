package br.umc.faces.bean;

import static br.umc.faces.page.Page.CONSULT;
import static br.umc.faces.page.Page.DEPOSIT;
import static br.umc.faces.page.Page.LOGIN;
import static br.umc.faces.page.Page.WITHDRAW;

import java.io.IOException;
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

@Named
@SessionScoped
@SuppressWarnings("serial")
public class AccountLoggedBean implements Serializable {
	@Inject private AccountDAO dao;
	private Account account;
	private String logged;

	@PostConstruct
	public void init() {

		if (logged != null)
			account = dao.findByAccountNumber(logged);
	}

	@Produces @AccountLogged
	public String getLogged() {
		return logged;
	}

	public void register(final Account account) {
		dao.save(account);
		this.account = account;
		this.logged = account.getAccountNumber();
	}

	public void logout() throws IOException {
		FacesUtil.invalidateSession();
		FacesUtil.redirect(LOGIN.getURL());
	}

	public void redirectToConsult() throws IOException{
		FacesUtil.redirect(CONSULT.getURL());
	}
	
	public void redirectToWithdraw() throws IOException {
		FacesUtil.redirect(WITHDRAW.getURL());
	}
	
	public void redirectToDeposit() throws IOException {
		FacesUtil.redirect(DEPOSIT.getURL());
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(final Account account) {
		this.account = account;
	}
}