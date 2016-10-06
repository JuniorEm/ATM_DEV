package br.umc.faces.bean;

import static br.umc.faces.page.Page.INDEX;
import static br.umc.faces.page.Page.LOGIN;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import br.umc.data.dao.AccountDAO;
import br.umc.data.entity.Account;
import br.umc.faces.exception.BusinessException;
import br.umc.faces.util.FacesUtil;

@Named
@RequestScoped
public class LoginBean {

	@Inject private AccountDAO dao;
	@Inject private AccountLoggedBean bean;
	private Account account;

	@PostConstruct
	public void init() {
		account = new Account();
	}

	private void getAccountFound() throws BusinessException {
		final Optional<Account> optionalFound = Optional.ofNullable(dao.findByAccountNumberAndPinNumber(
				account.getAccountNumber().replace("/", "").replace("-", ""), account.getPinNumber()));
		final Account found = optionalFound.orElseThrow(() -> new BusinessException("Usuário/Senha inválidos"));
		bean.register(found);
	}

	public String login() {
		try {
			getAccountFound();
			return INDEX.getURL().concat("?faces-redirect=true");
		} catch(final BusinessException e) {
			FacesUtil.getFacesContext().addMessage(null, FacesUtil
						.getFacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return LOGIN.getURL().concat("?faces-redirect=true");
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
