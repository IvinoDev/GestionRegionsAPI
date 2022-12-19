package com.apigestionregion.springjwt;

import com.apigestionregion.springjwt.models.ERole;
import com.apigestionregion.springjwt.models.Role;
import com.apigestionregion.springjwt.models.User;
import com.apigestionregion.springjwt.repository.UserRepository;
import com.apigestionregion.springjwt.security.services.UserDetailsImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}
}
