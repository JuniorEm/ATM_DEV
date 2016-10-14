package br.umc.faces.model;

import java.math.BigDecimal;

import br.umc.data.entity.Account;
import br.umc.data.entity.WithdrawValue;
import br.umc.faces.exception.BusinessException;
import br.umc.faces.util.FacesFormat;

/**
 * Classe de modelo para lógica de saque.
 * @author Junior
 *
 */
public class Withdraw {
	private String previousBalance;
	
	public BigDecimal getValuePostWithdraw(final Account account, final WithdrawValue objectWithValue) throws BusinessException {
		final BigDecimal currentBalance = account.getBalance();
		this.previousBalance = FacesFormat.format(currentBalance);
		
		if (objectWithValue.getValueToBeWithdrawn().compareTo(currentBalance) > 0) {
			throw new BusinessException("Valor a ser sacado é maior do que o saldo");
		}
		
		return currentBalance.subtract(objectWithValue.getValueToBeWithdrawn());
	}
	
	public String getPreviousBalance() {
		return previousBalance;
	}
}
