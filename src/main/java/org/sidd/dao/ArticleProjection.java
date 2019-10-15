package org.sidd.dao;

import org.sidd.entites.Article;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="p1",types= {Article.class})
public interface ArticleProjection {
	public String getNom();
}
