package com.springboot.jpa.service;

import java.util.List;

import com.springboot.jpa.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);

	public Product updateProduct(Product product);

	public void deleteProduct(Integer id);

	public Product getProduct(Integer id);

	public List<Product> getAllProduct();

	public List<Product> searchProduct(String query);


}
