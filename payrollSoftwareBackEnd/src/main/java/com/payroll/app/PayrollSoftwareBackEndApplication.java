package com.payroll.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PayrollSoftwareBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollSoftwareBackEndApplication.class, args);
	}

}
