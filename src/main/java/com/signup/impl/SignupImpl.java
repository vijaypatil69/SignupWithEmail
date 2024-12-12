package com.signup.impl;

import java.io.UnsupportedEncodingException;

import com.signup.model.DataComponent;
import com.signup.model.DataModel;

import jakarta.mail.MessagingException;

public interface SignupImpl {

	boolean checkDataPresentOrNot(DataComponent dataComponent);

	void sendEmail(String email, String subject, String content) throws UnsupportedEncodingException, MessagingException;

	DataModel setDataInDataModel(DataComponent dataComponent);

}
