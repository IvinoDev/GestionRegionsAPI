package com.apigestionregion.springjwt;

import com.apigestionregion.springjwt.models.ERole;
import com.apigestionregion.springjwt.models.Role;
import com.apigestionregion.springjwt.models.User;
import com.apigestionregion.springjwt.repository.RoleRepository;
import com.apigestionregion.springjwt.repository.UserRepository;
import com.apigestionregion.springjwt.security.services.UserDetailsImpl;
import com.apigestionregion.springjwt.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class SpringBootSecurityJwtApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		User newProfilAdmin = userRepository.findByUsername("MKDev");
		User newProfilUser = userRepository.findByUsername("BabaBallo");
		if(newProfilAdmin == null && newProfilUser == null) {
			Role roleUser = new Role();
			roleUser.setName(ERole.ROLE_USER);
			roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setName(ERole.ROLE_ADMIN);
			roleRepository.save(roleAdmin);

			User user1 = new User();
			user1.setUsername("Mkdev");
			user1.setEmail("mk@orange.ml");
			//user1.setPassword("mk123");
			user1.setPassword(passwordEncoder.encode("mk123"));
			userRepository.save(user1);

			User user2 = new User();
			user2.setUsername("BabaBallo");
			user2.setEmail("ballo@orange.ml");
			//user2.setPassword("bl123");
			user2.setPassword(passwordEncoder.encode("bl123"));
			userRepository.save(user2);

			userDetailsService.addRoleToUser(roleUser.getName(), "Mkdev");
			userDetailsService.addRoleToUser(ERole.ROLE_ADMIN, "BabaBallo");


		}
		System.out.println("App successfully launched with our default users");
	}
}
