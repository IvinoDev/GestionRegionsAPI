package com.apigestionregion.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apigestionregion.springjwt.models.ERole;
import com.apigestionregion.springjwt.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
//  @Query(value = "SELECT roles.id, roles.name from roles WHERE roles.name = :name", nativeQuery = true)
  Optional<Role> findByName(ERole name);
}
