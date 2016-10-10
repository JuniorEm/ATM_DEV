package br.umc.faces.model;

import java.math.BigDecimal;

import br.umc.data.entity.Account;
import br.umc.data.entity.WithdrawValue;
import br.umc.faces.util.FacesFormat;

/**
 * Classe de modelo para lógica de saque.
 * @author Junior
 *
 */
public class Withdraw {
	private String previousBalance;
	
	public BigDecimal getValuePostWithdraw(final Account account, final WithdrawValue objectWithValue) {
		final BigDecimal currentBalance = account.getBalance();
		this.previousBalance = FacesFormat.format(currentBalance);
		return currentBalance.subtract(objectWithValue.getValueToBeWithdrawn());
	}
	
	public String getPreviousBalance() {
		return previousBalance;
	}
}
