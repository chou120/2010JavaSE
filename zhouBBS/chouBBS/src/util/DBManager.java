package com.sxt.bbs.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库管理类
 * 
 * @author LiangJie
 *
 */
public class DBManager {
	/**
	 * 初始化连接池对象
	 */

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ComboPooledDataSource ds = null;
	static {
		ds = new ComboPooledDataSource();
	}

	/**
	 * 获得连接
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static DataSource getDataSource() {
		return ds;
	}

	public static void createConnection() throws SQLException {
		conn = ds.getConnection();
	}

	/**
	 * 执行查询
	 * 
	 * @param sql
	 * @return ResultSet
	 */
	public static ResultSet queryDb(String sql) {
		try {
			createConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 关闭连接
	 */
	public static void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
