package com.signup.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.signup.impl.SignupImpl;
import com.signup.model.DataComponent;
import com.signup.model.DataModel;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/signup")
public class SigupController {

	@Autowired
	SignupImpl signupImpl;

	@PostMapping("/data")
	public String signupData(@RequestBody DataComponent dataComponent) {
		System.out.println(dataComponent);
		boolean presentOrNot = signupImpl.checkDataPresentOrNot(dataComponent);
		System.out.println(presentOrNot);
		if (presentOrNot == false) {
			DataModel dataModel = signupImpl.setDataInDataModel(dataComponent);
			System.out.println(dataModel);
			String subject = "Your Password";
			String content = "Hi " + dataModel.getName() + " This is your Password " + dataModel.getPassword();
			try {
				signupImpl.sendEmail(dataModel.getEmailId(), subject, content);
				return "Password sent to " + dataComponent.getUserName() + " on " + dataComponent.getEmailId();

			} catch (UnsupportedEncodingException | MessagingException e) {
				return "Failed to send email. Error: " + e.getMessage();
			}

		}

		return "This email id already present ";

	}

}
