package br.umc.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade de domínio para valores de saque.
 * @author Junior
 *
 */
@Entity
@Table(name = "WITHDRAW_VALUE")
@SuppressWarnings("serial")
public class WithdrawValue implements Serializable {
	
	@Id
	@Column
	private Long id;
	
	@Column(name = "VALUE_TO_BE_WITHDRAWN")
	private BigDecimal valueToBeWithdrawn;
	
	public WithdrawValue() {}
	
	public Long getId() {
		return id;
	}
	
	public BigDecimal getValueToBeWithdrawn() {
		return valueToBeWithdrawn;
	}
	
	public void setValueToBeWithdrawn(final BigDecimal valueToBeWithdrawn) {
		this.valueToBeWithdrawn = valueToBeWithdrawn;
	}
}
