package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	boolean insertProducts(Product p);

	Product getById(int pid);

	boolean updateProduct(Product p);

	boolean deleteProduct(int pid);

}
