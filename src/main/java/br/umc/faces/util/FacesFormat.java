package br.umc.faces.util;

import java.math.BigDecimal;

public final class FacesFormat {
	private static final String BRL = "R$";
	
	public static String format(final BigDecimal value) {
		return BRL.concat(value.toString()).replace(".", ",");
	}
}
