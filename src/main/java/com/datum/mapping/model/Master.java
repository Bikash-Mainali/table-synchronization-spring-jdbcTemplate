package com.datum.mapping.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="master",schema="master_schema")
public class Master implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "client_code")
	private int clientCode;

	@Column(name = "account_no")
	private Long accountNo;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "modify_date")
	private Date modifyDate;

	public int getClientCode() {
		return clientCode;
	}

	public void setClientCode(int clientCode) {
		this.clientCode = clientCode;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "\n{\"clientCode\": \"" + clientCode + "\",\"accountNo\": \"" + accountNo + "\",\"accountName\": \""
				+ accountName + "\",\"modifyDate\": \"" + modifyDate + "\"}";
	}

}
