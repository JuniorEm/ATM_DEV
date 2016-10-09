package br.umc.faces.model;

import br.umc.data.entity.Account;
import br.umc.faces.util.FacesFormat;

/**
 * Classe de modelo para consulta.
 * @author Junior
 *
 */
public final class Consult {
	private String agency;
	private String accountNumber;
	private String balance;
	
	public Consult() {}
	
	public void extract(final Account account) {
		final String agencyWithAccountNumber = account.getAccountNumber();
		agency = agencyWithAccountNumber.substring(0,4);
		accountNumber = agencyWithAccountNumber.substring(4,10);
		balance = FacesFormat.format(account.getBalance());
	}

	public String getAgency() {
		return agency;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getBalance() {
		return balance;
	}
}
