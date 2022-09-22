package com.springboot.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.model.Product;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.service.ProductService;

@Service
public class ProductImplimentation implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		Product prod = productRepository.save(product);

		return prod;
	}

	@Override
	public Product updateProduct(Product product) {

		Product prod = productRepository.save(product);
		return prod;
	}

	@Override
	public Product getProduct(Integer id) {

		Optional<Product> product1 = productRepository.findById(id);
		Product productResponse = product1.get();

		return productResponse;

	}

	@Override
	public List<Product> getAllProduct() {

		List<Product> productList = productRepository.findAll();
		return productList;
	}

	@Override
	public void deleteProduct(Integer id) {

		productRepository.deleteById(id);
	}

	@Override
	public List<Product> searchProduct(String query) {

		List<Product> products = productRepository.searchProduct(query);
		return products;
	}

}
