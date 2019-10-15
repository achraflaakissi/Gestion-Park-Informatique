package org.sidd.web;

import java.util.List;
import org.sidd.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/articles/distinct-unite")
	public List<String> distinctunite(){
		return articleRepository.distinctunite();
	}
	@GetMapping("/articles/etat-stock")
	public List<Object> EtatStock(){
		return articleRepository.ListEtatStock();
	}
	@GetMapping("/articles/inventer-article")
	public List<Object> InventerArticle(){
		return articleRepository.InventerArticle();
	}
	@GetMapping("/articles/etat-materiel-donner")
	public List<Object> EtatMaterielDonnerStock(){
		List<Object> l =articleRepository.EtatMaterielDonnerStock();
		l.addAll(articleRepository.EtatMaterielDonnerEmplacement());
		return l ;
	}
	
}
