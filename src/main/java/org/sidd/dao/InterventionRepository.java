package org.sidd.dao;

import java.util.Date;
import java.util.List;

import org.sidd.entites.Article;
import org.sidd.entites.Intervention;
import org.sidd.entites.Userintervention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "*", maxAge = 3600)
public interface InterventionRepository extends JpaRepository<Intervention, Long> {

	
	
	@Query("select i.equipe from Intervention i where i.date_intervention <= :creationDateTime")
	public List<String> Filtrer(@Param("creationDateTime") Date creationDateTime);

	
	@Query("select i from Intervention i where i.validerresponsable=0 and i.id in (select u.intervention.id from Userintervention u where u.user.username=?1)")
	public Page<Intervention> InterventionBYUser(@Param("u") String u,Pageable pageRequest);
	
	public Page<Intervention> findByValiderresponsable(@Param("u") Boolean u,Pageable pageRequest);
	
	public Page<Intervention> findByValider(@Param("u") Boolean u,Pageable pageRequest);
	
	public Page<Intervention> findByValiderAndTypeContainingAndEquipeContaining(@Param("v") Boolean v,@Param("t") String t,@Param("e") String e,Pageable pageRequest);
	
	public Page<Intervention> findByEquipeContaining(@Param("e") String e,Pageable pageRequest);
	
	@Query("select i from Intervention i where i.date_reclamation<=NOW() and i.validerresponsable=0 and i.id in (select u.intervention.id from Userintervention u where u.user.username=?1)")
	public Page<Intervention> InterventionOfTodayByUser(@Param("u") String u,Pageable pageRequest);
	
}
