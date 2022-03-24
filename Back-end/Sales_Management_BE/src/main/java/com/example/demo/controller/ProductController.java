package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	// get all product
	@GetMapping("")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	// create product rest api
	@PostMapping("/create_product")
	public Product createProdct(@RequestBody Product product) {
		return productService.createProdct(product);
	}
//		
//	// get product by id rest api
//	@GetMapping("/products/{id}")
//	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
//		return productService.getProductById(id);
//		
//	}
//	
//	// update employee rest api
//	@PutMapping("/products/{id}")
//	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
//		return productService.updateProduct(id, productDetails);
//	}
//	
//	// delete product rest api
//	@DeleteMapping("/products/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id){
//		return productService.deleteProduct(id);
//	}
		
		

}
