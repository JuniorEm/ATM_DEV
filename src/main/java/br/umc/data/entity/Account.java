package br.umc.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade responsável por representar "Conta"
 * @author Junior
 *
 */
@Entity
@Table(name = "ACCOUNT")
@SuppressWarnings("serial")
public class Account implements Serializable {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;
	
	@Column(name = "PIN_NUMBER")
	private String pinNumber;
	
	@Column(name = "BALANCE")
	private BigDecimal balance;
	
	public Account() {}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(final String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(final String pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	public BigDecimal getBalance() {
		if (balance == null)
			balance = new BigDecimal("0.00");
		return balance;
	}
	
	public void setBalance(final BigDecimal balance) {
		this.balance = balance;
	}
}
