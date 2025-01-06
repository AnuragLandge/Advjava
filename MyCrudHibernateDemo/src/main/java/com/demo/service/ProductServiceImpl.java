package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	Scanner sc = new Scanner(System.in);
	private ProductDao pdao;

	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}

	@Override
	public void closeConnection() {
		pdao.closeMyConnection();
	}

	@Override
	public void addNewProduct() {
		System.out.println("Enter product name:");
		String nm = sc.next();
		System.out.println("Enter product quantity: ");
		int qty = sc.nextInt();
		System.out.println("Enter price: ");
		double price = sc.nextDouble();
		Product p1 = new Product(nm, qty, price);
		pdao.addProduct(p1);
	}

	@Override
	public List<Product> displayAll() {
		return pdao.displayAllProduct();
	}

	@Override
	public boolean deleteById(int pid) {
		return pdao.removeById(pid);
	}

	@Override
	public boolean updateById(int pid, int qty, double price) {

		return pdao.updateById(pid, qty, price);
	}

	@Override
	public Product displayById(int pid) {
		return pdao.displayById(pid);
	}

	@Override
	public List<Product> sortByName() {
		return pdao.sortByName();
	}

}
