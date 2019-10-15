package org.sidd.dao;

import org.sidd.entites.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*", maxAge = 3600)
public interface StockRepository extends JpaRepository<Stock, Long> {

}
