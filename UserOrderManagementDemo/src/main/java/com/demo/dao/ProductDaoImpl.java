package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {

	static Connection conn;
	static PreparedStatement getall, selbyid, getById;
	static {
		try {
			conn = DBUtil.getMyConnection();
			getall = conn.prepareStatement("select * from category");
			selbyid = conn.prepareStatement("select * from product where cid=?");
			getById = conn.prepareStatement("select * from product where pid=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> findAllCategories() {
		List<Category> clist = new ArrayList<>();
		try {
			ResultSet rs = getall.executeQuery();
			while (rs.next()) {
				clist.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			return clist;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Product> findAllProductById(int cid) {
		List<Product> plist = new ArrayList<>();
		try {
			selbyid.setInt(1, cid);
			ResultSet rs = selbyid.executeQuery();
			while (rs.next()) {
				plist.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),
						rs.getDate(5).toLocalDate(), rs.getInt(6)));
			}
			if (plist.size() > 0) {
				return plist;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getById(int id) {
		try {
			getById.setInt(1, id);
			ResultSet rs = getById.executeQuery();
			if (rs.next())
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),
						rs.getDate(5).toLocalDate(), rs.getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
