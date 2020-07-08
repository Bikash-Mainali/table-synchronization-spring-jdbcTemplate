package com.datum.mapping.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer",schema="customer")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "client_code")
	private int clientCode;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "father_name")
	private String fatherName;

	@Column(name = "modify_date")
	private Date modifyDate;


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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "\n{\"clientCode\": \"" + clientCode + "\",\"firstName\": \"" + firstName + "\",\"lastName\": \""
				+ lastName + "\",\"fatherName\": \"" + fatherName + "\",\"modifyDate\": \"" + modifyDate + "\"}";
	}

}
