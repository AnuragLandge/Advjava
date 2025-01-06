package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addNewProduct(Product p) {
		jdbcTemplate.update("insert into spring_product values(?,?,?,?,?,?)",
				new Object[] { p.getPid(), p.getPname(), p.getQty(), p.getPrice(), p.getExpdate(), p.getCid() });
	}

	@Override
	public boolean deleteProduct(int id) {
		int n = jdbcTemplate.update("delete from spring_product where pid=?", new Object[] { id });
		if (n > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateProduct(int id, Product p) {
		int n = jdbcTemplate.update("update spring_product values(?,?,?,?) where pid=?",
				new Object[] { p.getPname(), p.getQty(), p.getPrice(), p.getCid(), id });
		if (n > 0)
			return true;
		return false;
	}

	@Override
	public List<Product> getAll() {
		List<Product> plist = jdbcTemplate.query("select * from spring_product",
				new BeanPropertyRowMapper<>(Product.class));
		return plist.isEmpty() ? null : plist;
	}

	@Override
	public Product findById(int id) {
		Product p = jdbcTemplate.queryForObject("select * from spring_product where pid=?", new Object[] { id },
				new BeanPropertyRowMapper<>(Product.class));
		if (p != null)
			return p;
		return null;
	}

	@Override
	public List<Product> getSortedByPrice() {
		List<Product> plist = jdbcTemplate.query("select * from spring_product order by price",
				new BeanPropertyRowMapper<>(Product.class));
		return plist.isEmpty() ? null : plist;
	}

	@Override
	public List<Product> getProductLessThanPrice(double price) {
		List<Product> plist = jdbcTemplate.query("select * from spring_product where price<=?", new Object[] { price },
				new BeanPropertyRowMapper<>(Product.class));
		return plist.isEmpty() ? null : plist;
	}

}
