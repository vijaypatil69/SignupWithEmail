package com.signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.signup")
public class SigupWithEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigupWithEmailApplication.class, args);
	}

}
