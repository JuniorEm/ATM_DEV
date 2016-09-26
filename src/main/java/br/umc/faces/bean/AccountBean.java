package br.umc.faces.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.umc.data.dao.AccountDAO;
import br.umc.data.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class AccountBean implements Serializable {
	
	@Inject private AccountDAO dao;
	private Account account;
	@Getter @Setter private String message;
	
	@PostConstruct
	public void init() {
		message = "Exemplo de mensagem!";
		account = new Account();
	}
	
	@Transactional
	public void save() {
		dao.save(account);		
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
