package com.signup.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.signup.model.DataModel;

@Service
public class UserPasswordGenreatedService {
	private final Random random = new Random();

	public String autoGenerateUserPassword(DataModel dataModel) {
		String str = dataModel.getName().substring(0, 2);

		int pass = 100000 + random.nextInt(900000);
		str = str + pass;

		return str;

	}

}
