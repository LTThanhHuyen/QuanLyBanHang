package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	// create Product rest api
		
	public Product createProdct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	// get product by id rest api
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Product employee = productRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exits with id: " + id));
		return ResponseEntity.ok(employee);	
	}
	
	// update product rest api
		
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		product.setName(productDetails.getName());
		product.setQuantity(productDetails.getQuantity());
		product.setPrice(productDetails.getPrice());
		product.setImage(productDetails.getImage());
		product.setStatus(productDetails.getStatus());
		product.setUpdated_user(productDetails.getUpdated_user());
		product.setUpdated_at(productDetails.getCreated_at());
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	// delete employee rest api
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	

}
