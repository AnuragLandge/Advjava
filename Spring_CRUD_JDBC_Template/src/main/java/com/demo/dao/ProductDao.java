package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void addNewProduct(Product p);

	boolean deleteProduct(int id);

	boolean updateProduct(int id, Product p);

	List<Product> getAll();

	Product findById(int id);

	List<Product> getSortedByPrice();

	List<Product> getProductLessThanPrice(double price);

}
