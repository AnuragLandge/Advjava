package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProductDao {

	List<Category> findAllCategories();

	List<Product> findAllProductById(int cid);

	Product getById(int id);

}
