package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void closeConnection();

	void addNewProduct();

	List<Product> displayAll();

	boolean deleteById(int pid);

	boolean updateById(int pid, int qty, double price);

	Product displayById(int pid);

	List<Product> sortByName();

	
	
}
