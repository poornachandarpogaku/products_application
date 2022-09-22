package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//	@Query("SELECT p FROM Product p WHERE "
//			+ "p.brand LIKE CONCAT('%', :query , '%')")
//	List<Product> searchProduct(String query);

	@Query(value = "SELECT * FROM productdetails p WHERE "
			+ "p.brand LIKE CONCAT('%', :query , '%')", nativeQuery = true)
	List<Product> searchProduct(String query);

}
