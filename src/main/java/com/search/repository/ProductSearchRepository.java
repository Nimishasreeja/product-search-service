package com.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.search.entity.Product;


@Repository
public interface ProductSearchRepository extends JpaRepository<Product, Long>  {
	
	
	@Query("Select p from Product p where p.keyword in :keywords")
	    List<Product> findByKeywords(@Param("keywords") List<String> keywords);

}
