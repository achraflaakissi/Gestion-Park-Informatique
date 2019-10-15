package org.sidd.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.sidd.entites.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*", maxAge = 3600)
public interface ArticleRepository extends JpaRepository<Article, Long> {

	@Query("select a from Article a where a.nom like %?1% and a.mark like %?2% and a.modele like %?3% and a.sn like %?4% and a.type like %?5% and a.unite like %?6%")
	public Page<Article> Filtrer(@Param("nom") String nom,@Param("mark") String mark,@Param("modele") String modele,@Param("sn") String sn
			,@Param("type") String type,@Param("unite") String unite,Pageable pageRequest	);
	
	public List<Article> findByUnite(@Param("unite") String unite);
	
	@Query("SELECT DISTINCT a.unite as resultat from Article a")
	public List<String> distinctunite();

	@Query(
			  value = "SELECT nom,count(id) FROM `article` WHERE `code_stock` is not null group by nom", 
			  nativeQuery = true)
	public List<Object> ListEtatStock();
	@Query(value = "SELECT nom,count(id) FROM `article` group by nom", nativeQuery = true)
	public List<Object> InventerArticle();
	@Query(value = "SELECT a.`nom` as 'product',s.nom as 'emplacement' FROM `article` a inner join stock s on s.id=a.code_stock where materialdonner=1", nativeQuery = true)
	public List<Object> EtatMaterielDonnerStock();
	@Query(value = "SELECT a.`nom` as 'product',e.nom as 'emplacement' FROM `article` a inner join emplacement e on e.id=a.code_epl where materialdonner=1", nativeQuery = true)
	public List<Object> EtatMaterielDonnerEmplacement();
}
