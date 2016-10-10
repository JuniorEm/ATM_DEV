package br.umc.faces.model;

import java.math.BigDecimal;

import br.umc.faces.util.FacesFormat;

public class Deposit {
	private BigDecimal value;
	private String previousBalance;
		
	public BigDecimal getValue() {
		return value;
	}

	public void setValue(final BigDecimal value) {
		this.value = value;
	}

	public String getPreviousBalance() {
		return previousBalance;
	}
	
	public void setPreviousBalance(final String previousBalance) {
		this.previousBalance = previousBalance;
	}

	public void setFormattedPreviousBalance(final BigDecimal previousBalance) {
		this.previousBalance = FacesFormat.format(previousBalance);
	}
}
