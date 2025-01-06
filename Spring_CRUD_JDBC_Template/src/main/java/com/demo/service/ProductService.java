package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	boolean deleteProduct(int id);

	boolean modifyProduct(int id);

	List<Product> displayAll();

	Product displayById(int id);

	List<Product> displaySortedByPrice();

	List<Product> displayProductLessThanPrice(double price);

}
