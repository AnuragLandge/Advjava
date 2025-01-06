package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class LoginDaoImpl implements LoginDao {

	static Connection con;
	static PreparedStatement selUser;
	static {
		try {
			con = DBUtil.getMyConnection();
			selUser = con.prepareStatement("select uname,pwd,role from user where uname=? and pwd=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MyUser authenticateUser(String uname, String pass) {
		try {
			selUser.setString(1, uname);
			selUser.setString(2, pass);
			ResultSet rs = selUser.executeQuery();
			if (rs.next())
				return new MyUser(rs.getString(1), rs.getString(2), rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
