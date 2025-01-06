package com.demo.SpringbootProductCRUDMVC.service;

import java.util.List;

import com.demo.SpringbootProductCRUDMVC.beans.Product1;

public interface ProductService {

	List<Product1> getAllProducts();

	Product1 getProductById(int pid);

	Product1 addNewProduct(Product1 p);

	boolean updateProduct(Product1 p);

	boolean deleteProductById(int pid);

	boolean insertProducts(Product1 p);

}
