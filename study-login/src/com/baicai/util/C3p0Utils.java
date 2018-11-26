package com.baicai.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 基于c3p0的JDBC工具类
 */
public final class C3p0Utils {

	private static ComboPooledDataSource cpds = new ComboPooledDataSource();

	//私有构造
	private C3p0Utils(){}

	// 获得连接
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 释放资源（3个）
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(conn, stmt);
	}

	//// 释放资源（2个）
	public static void release(Connection conn, Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}