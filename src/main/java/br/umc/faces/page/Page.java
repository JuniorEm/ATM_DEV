package br.umc.faces.page;

public enum Page {
	LOGIN("login.xhtml"), 
	INDEX("index.xhtml"), 
	CONSULT("consult.xhtml"), 
	WITHDRAW("withdraw.xhtml"),
	DEPOSIT("deposit.xhtml");
	
	private final String URL;
	
	Page(final String URL) {
		this.URL = URL;
	}
	
	public String getURL() {
		return URL;
	}
}
