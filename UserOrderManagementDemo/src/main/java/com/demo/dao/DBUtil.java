package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;

	public static Connection getMyConnection() {
		if (con == null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url = "jdbc:mysql://192.168.10.127:3306/dac16?useSSL=false";
				con = DriverManager.getConnection(url, "dac16", "welcome");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return con;
	}

	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
