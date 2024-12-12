package com.signup.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.signup.impl.SignupImpl;
import com.signup.model.DataComponent;
import com.signup.model.DataModel;
import com.signup.repo.SingnupRepo;

import jakarta.mail.MessagingException;

@Service
public class SignupService implements SignupImpl {
	@Autowired
	JavaMailSender javaMailSender;
	@Value("$(spring.mail.username)")
	String fromEmail;
//ftro mkiq qdpk ysig
	@Autowired
	SingnupRepo singnupRepo;
	DataModel dataModel = new DataModel();
	@Autowired
	UserPasswordGenreatedService userPasswordGenreatedService;

	@Override
	public boolean checkDataPresentOrNot(DataComponent dataComponent) {

		if (singnupRepo.checkData(dataComponent.getEmailId()).size() > 0) {
			return true;
		} else
			return false;

	}

	@Override
	public void sendEmail(String email, String subject, String content)
			throws UnsupportedEncodingException, MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		message.setTo(email);
		message.setSubject(subject);
		message.setText(content);
		javaMailSender.send(message);

	}

	@Override
	public DataModel setDataInDataModel(DataComponent dataComponent) {
		dataModel.setEmailId(dataComponent.getEmailId());
		dataModel.setName(dataComponent.getUserName());
		dataModel.setMobileNo(dataComponent.getMobileNo());
		dataModel.setPassword(userPasswordGenreatedService.autoGenerateUserPassword(dataModel));
		singnupRepo.save(dataModel);
		return dataModel;

	}

}
