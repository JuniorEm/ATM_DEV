package br.umc.faces.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.umc.data.dao.AccountDAO;
import br.umc.data.entity.Account;
import br.umc.faces.model.Deposit;
import br.umc.faces.util.FacesUtil;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class DepositBean implements Serializable {
	@Inject private AccountDAO accountDAO;
	@Inject private AccountLoggedBean logged;
	private Account account;
	private Deposit deposit;

	@PostConstruct
	public void init() {
		account = logged.getAccount();
		deposit = new Deposit();
	}

	public void deposit() {
		final BigDecimal currentBalance = account.getBalance();
		deposit.setFormattedPreviousBalance(currentBalance);

		final BigDecimal postDepositBalance = currentBalance.add(deposit.getValue());
		account.setBalance(postDepositBalance);
		accountDAO.save(account);
		showConfirmationDialog();
	}

	private void showConfirmationDialog() {
		final RequestContext requestContext = FacesUtil.getRequestContext();
		requestContext.execute("PF('deposit_confirm').show();");
		requestContext.update("dlg_deposit");
	}

	public Account getAccount() {
		return account;
	}

	public Deposit getDeposit() {
		return deposit;
	}
}
