package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService pservice;

	public ProductController() {
		super();
		System.out.println("Hello");
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> plist = pservice.getAllProduct();
		return ResponseEntity.ok(plist);
	}

	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addNewProducts(@RequestBody Product p) {
		boolean status = pservice.insertProducts(p);
		if (status) {
			return ResponseEntity.ok("Data added successfully");
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProducts(@RequestBody Product p) {
		boolean status = pservice.updateProduct(p);
		if (status) {
			return ResponseEntity.ok("Data updated successfully");
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProducts(@PathVariable int pid) {
		boolean status = pservice.deleteProduct(pid);
		if (status)
			return ResponseEntity.ok("Data deleted successfully");
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
