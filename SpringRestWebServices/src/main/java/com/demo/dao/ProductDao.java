package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAllProducts();

	boolean addProduct(Product p);

	Product findById(int pid);

	boolean modifyProduct(Product p);

	boolean removeProduct(int pid);

}
