package br.umc.faces.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.umc.data.dao.AccountDAO;
import br.umc.data.entity.Account;
import br.umc.faces.page.Page;

@Named
@RequestScoped
public class LoginBean {
	
	private Page page;
	@Inject private AccountDAO dao;
	@Inject private AccountLoggedBean bean;
	private Account account;
	
	
	@PostConstruct
	public void init() {
		account = new Account();
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccountData() {
		final Account found = dao.findByAccountNumberAndPinNumber(account.getAccountNumber(), account.getPinNumber());
		
		if (found == null) {
			return null;
		}
		
		bean.register("S");
		return found;
	}
	
	public String login() {
		if (getAccountData() == null)
			return null;
		return Page.INDEX.getURL().concat("?faces-redirect=true");
	}
	
}
