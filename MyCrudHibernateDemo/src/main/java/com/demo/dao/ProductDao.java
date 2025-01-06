package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void closeMyConnection();

	void addProduct(Product p1);

	List<Product> displayAllProduct();

	boolean removeById(int pid);

	boolean updateById(int pid, int qty, double price);

	Product displayById(int pid);

	List<Product> sortByName();

}
