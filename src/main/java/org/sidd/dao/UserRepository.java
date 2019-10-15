package org.sidd.dao;

import org.sidd.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*", maxAge = 3600)
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(@Param("username") String username);
}
