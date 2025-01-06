package com.demo.SpringbootProductCRUDMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.SpringbootProductCRUDMVC.beans.Product1;
import com.demo.SpringbootProductCRUDMVC.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao pdao;

	@Override
	public List<Product1> getAllProducts() {
		return pdao.findAll();
	}

	@Override
	public Product1 getProductById(int pid) {
		return pdao.findById(pid).orElse(null);
	}

	@Override
	public Product1 addNewProduct(Product1 p) {
		return pdao.save(p);
	}

	@Override
	public boolean updateProduct(Product1 p) {
		Optional<Product1> op = pdao.findById(p.getPid());
		if (op.isPresent()) {
			Product1 p2 = op.get();
			p2.setPname(p.getPname());
			p2.setQty(p.getQty());
			p2.setPrice(p.getPrice());
			pdao.save(p2);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProductById(int pid) {
		Optional<Product1> op = pdao.findById(pid);
		if (op.isPresent()) {
			pdao.delete(op.get());
			return true;
		}
		return false;
	}

	@Override
	public boolean insertProducts(Product1 p) {
		Product1 p1 = pdao.save(p);
		return p1 != null;
	}

}
