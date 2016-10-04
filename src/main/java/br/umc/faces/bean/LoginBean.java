package br.umc.faces.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.umc.data.dao.AccountDAO;
import br.umc.data.entity.Account;
import static br.umc.faces.page.Page.INDEX;

@Named
@RequestScoped
public class LoginBean {

	@Inject
	private AccountDAO dao;
	@Inject
	private AccountLoggedBean bean;
	private Account account;

	@PostConstruct
	public void init() {
		account = new Account();
	}

	private Account getAccountFound() {
		final Account found = dao.findByAccountNumberAndPinNumber(account.getAccountNumber(), account.getPinNumber());

		if (found == null) {
			return null;
		}

		bean.register("S");
		return found;
	}

	public String login() {
		if (getAccountFound() == null)
			return null;
		return INDEX.getURL().concat("?faces-redirect=true");
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
