package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao pdao;

	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}

	@Override
	public List<Category> getAllCategory() {
		return pdao.findAllCategories();
	}

	@Override
	public List<Product> getAllProductsById(int cid) {
		return pdao.findAllProductById(cid);
	}

	@Override
	public Product getById(int id) {
		return pdao.getById(id);
	}

}
