package org.sidd.dao;

import org.sidd.entites.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRole(@Param("role") String role);
}
