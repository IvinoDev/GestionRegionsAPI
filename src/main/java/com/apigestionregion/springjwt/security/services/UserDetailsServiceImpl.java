package com.apigestionregion.springjwt.security.services;

import com.apigestionregion.springjwt.models.ERole;
import com.apigestionregion.springjwt.models.Role;
import com.apigestionregion.springjwt.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apigestionregion.springjwt.models.User;
import com.apigestionregion.springjwt.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

  public void addRoleToUser(ERole eRole, String username) {
    Optional<User> user = userRepository.findByUsername(username);
    Optional<Role> eRole1 = roleRepository.findByName(eRole);
    user.get().getRoles().add(eRole1.get());
    userRepository.save(user.get());
  }


}
