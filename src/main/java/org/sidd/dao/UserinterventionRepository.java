package org.sidd.dao;

import java.util.List;

import org.sidd.entites.Article;
import org.sidd.entites.Userintervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*", maxAge = 3600)
public interface UserinterventionRepository extends JpaRepository<Userintervention, Long> {
	public List<Article> findByUser(@Param("user") String user);
	@Query("select u from Userintervention u where u.user.id=?1")
	public List<Userintervention> InterventionBYUser(@Param("u") Long u);
}
