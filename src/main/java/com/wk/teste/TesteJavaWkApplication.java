package com.wk.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TesteJavaWkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteJavaWkApplication.class, args);
		
//		BCryptPasswordEncoder x = new BCryptPasswordEncoder();
//		System.out.println(x.encode("admin"));
	}

}
