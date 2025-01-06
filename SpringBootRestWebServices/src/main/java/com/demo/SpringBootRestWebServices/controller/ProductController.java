package com.demo.SpringBootRestWebServices.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootRestWebServices.dto.ProductDto;
import com.demo.SpringBootRestWebServices.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	ProductService pservice;

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> plist = pservice.getAllProducts();
		return ResponseEntity.ok(plist);
	}

	@RequestMapping(value = "/products/{pid}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ProductDto> getProductById(@PathVariable int pid) {
		ProductDto pdto = pservice.getProductById(pid);
		if (pdto != null)
			return ResponseEntity.ok(pdto);
		else
			return ResponseEntity.status(500).body(null);
	}

	@RequestMapping(value="/products", method=RequestMethod.POST,produces = "application/json")
	public ResponseEntity<String> addNewProduct(@RequestBody ProductDto pdto) {
		boolean status = pservice.addNewProduct(pdto);
		if (status) {
			return ResponseEntity.ok("Data added successfully");
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/products/{pid}", method=RequestMethod.PUT,produces = "application/json")
	public ResponseEntity<String> updateProduct(@PathVariable int pid, @RequestBody ProductDto pdto) {
		boolean status = pservice.updateProduct(pid, pdto);
		if (status)
			return ResponseEntity.ok("Data Updated Successfully!");
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value="/products/{pid}", method=RequestMethod.DELETE,produces = "application/json")
	public ResponseEntity<String> deleteProductById(@PathVariable int pid) {
		boolean status = pservice.deleteById(pid);
		if (status) {
			return ResponseEntity.ok("Data deleted successfully");
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

}
