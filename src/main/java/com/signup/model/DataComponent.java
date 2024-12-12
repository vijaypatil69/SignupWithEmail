package com.signup.model;

import org.springframework.stereotype.Component;

@Component
public class DataComponent {

	private String userName;
	private String emailId;
	private String mobileNo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "DataComponent [userName=" + userName + ", emailId=" + emailId + ", mobileNo=" + mobileNo + "]";
	}

}
