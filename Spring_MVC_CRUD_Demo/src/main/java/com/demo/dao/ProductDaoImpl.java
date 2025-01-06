package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> findAllProducts() {
		return jdbcTemplate.query("select * from products", (rs, rownum) -> {
			Product p = new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			p.setExpdate(rs.getDate(5).toLocalDate());
			p.setCid(rs.getInt(6));
			return p;
		});
	}

	@Override
	public boolean addProduct(Product p) {
		int n = jdbcTemplate.update("insert into products values(?,?,?,?,?,?)",
				new Object[] { p.getPid(), p.getPname(), p.getQty(), p.getPrice(), "2025-01-05", p.getCid() });
		return n > 0;
	}

	@Override
	public Product findById(int pid) {
		try {
			return jdbcTemplate.queryForObject("select * from products where pid=?", new Object[] { pid },
					(rs, rownum) -> {
						Product p = new Product();
						p.setPid(rs.getInt(1));
						p.setPname(rs.getString(2));
						p.setQty(rs.getInt(3));
						p.setPrice(rs.getDouble(4));
						p.setExpdate(rs.getDate(5).toLocalDate());
						p.setCid(rs.getInt(6));
						return p;
					});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean modifyProduct(Product p) {
		int n = jdbcTemplate.update("update products set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?",
				new Object[] { p.getPname(), p.getQty(), p.getPrice(), p.getExpdate(), p.getCid(), p.getPid() });
		return n > 0;
	}

	@Override
	public boolean removeProduct(int pid) {
		int n = jdbcTemplate.update("delete from products where pid=?", new Object[] { pid });
		return n > 0;
	}

}
