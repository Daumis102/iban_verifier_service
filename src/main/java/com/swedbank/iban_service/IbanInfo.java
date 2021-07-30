package com.swedbank.iban_service;
import java.util.List;

public class IbanInfo {

	private final Boolean valid;
	private final String iban;

	public IbanInfo(String iban, Boolean valid) {
		this.iban = iban;
		this.valid = valid;
	}

	public String getIban() {
		return iban;
	}

	public Boolean getValid(){
		return valid;
	}
}