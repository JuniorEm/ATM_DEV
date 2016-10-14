package br.umc.faces.bean;

import static br.umc.faces.page.Page.INDEX;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.umc.data.dao.AccountDAO;
import br.umc.data.entity.Account;
import br.umc.faces.exception.BusinessException;
import br.umc.faces.util.FacesUtil;
import br.umc.faces.util.MessagesUtil;

@Named
@RequestScoped
public class LoginBean {
	@Inject private MessagesUtil messages;
	@Inject private AccountDAO dao;
	@Inject private AccountLoggedBean bean;
	private Account account;

	@PostConstruct
	public void init() {
		account = new Account();
	}

	private void getAccountFound() throws BusinessException {
		final Optional<Account> optionalFound = Optional
				.ofNullable(dao.findByAccountNumberAndPinNumber(account.getAccountNumber().replace("/", "").replace("-", ""), 
						account.getPinNumber()));
		
		final Account found = optionalFound.orElseThrow(() -> new BusinessException("Usuário/Senha inválidos"));
		bean.register(found);
	}
	
	public void login() throws IOException {
		try {
			getAccountFound();
			FacesUtil.redirect(INDEX.getURL());
		} catch (final BusinessException e) {
			messages.displayErrorMessage("Error", e.getMessage());
		}
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
