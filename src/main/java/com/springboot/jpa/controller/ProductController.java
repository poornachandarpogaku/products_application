package com.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.model.Product;
import com.springboot.jpa.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productservice;

	@PostMapping("/save")
	public String saveProduct(@RequestBody Product p1) {

		Product pr = new Product();
		BeanUtils.copyProperties(p1, pr);
		Product pr1 = productservice.saveProduct(p1);
		String message = null;
		if (pr1 != null) {
			message = "Product saved successfully in Database";
		} else {
			message = "Product Not saved  in Database ";
		}
		return message;

	}

	@PutMapping("/update/{id}")
	public Product updateProduct(@RequestBody Product p1, @PathVariable Integer id) {
		Product product = new Product();
		product.setId(id);
		product.setBrand(p1.getBrand());
		product.setModelname(p1.getModelname());
		product.setOs(p1.getOs());
		product.setTechnology(p1.getTechnology());
		product.setPrice(p1.getPrice());
		Product product1 = productservice.updateProduct(product);
		return product1;
	}

	@GetMapping("/get/{id}")
	public Product findById(@PathVariable Integer id) {

		return productservice.getProduct(id);
	}

	@GetMapping("/getAll")
	public List<Product> findAll() {

		return productservice.getAllProduct();

	}

	@DeleteMapping("delete/{id}")
	public void deleteproduct(@PathVariable Integer id)

	{
		productservice.deleteProduct(id);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam("brand") String query) {

		return ResponseEntity.ok(productservice.searchProduct(query));

	}

}
