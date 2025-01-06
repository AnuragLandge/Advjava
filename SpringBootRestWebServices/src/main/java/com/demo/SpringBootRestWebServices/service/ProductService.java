package com.demo.SpringBootRestWebServices.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.SpringBootRestWebServices.beans.Product;
import com.demo.SpringBootRestWebServices.dto.ProductDto;

public interface ProductService {

	List<ProductDto> getAllProducts();

	ProductDto getProductById(int pid);

	boolean addNewProduct(ProductDto pdto);

	boolean updateProduct(int pid, ProductDto pdto);

	boolean deleteById(int pid);

}
