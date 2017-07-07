package com.kps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KpsSpringSecurityThymeleafDemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(KpsSpringSecurityThymeleafDemoApplication.class, args);
		
		/*ApplicationContext context = */
		//UserRepository repo = context.getBean(UserRepository.class);
		//System.out.println(repo.loadUserByUsername("sreynin"));
		
	}
}
