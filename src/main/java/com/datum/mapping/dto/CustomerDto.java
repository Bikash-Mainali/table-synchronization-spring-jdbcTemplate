package com.datum.mapping.dto;

public class CustomerDto {
	private int clientCode;
	private String firstName;
	public CustomerDto(int clientCode, String firstName) {
		super();
		this.clientCode = clientCode;
		this.firstName = firstName;
	}
	public int getClientCode() {
		return clientCode;
	}
	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}