package com.gft.immunization.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Address {
	
	@NotEmpty(message = "O campo não pode ser vazio.")
	private String zipCode;

	@NotEmpty(message = "O campo não pode ser vazio.")
	private String addressLine;
	
	@NotEmpty(message = "O campo não pode ser vazio.")
	private String number;
	
	private String additional;
	
	@NotEmpty(message = "O campo não pode ser vazio.")
	private String city;
	
	@NotEmpty(message = "O campo não pode ser vazio.")
	private String state;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
