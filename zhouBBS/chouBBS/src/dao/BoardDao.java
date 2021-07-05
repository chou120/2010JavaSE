package com.sxt.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sxt.bbs.util.DBManager;

public class BoardDao {
	/**
	 * 拿到主板块
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getBoard() {
		String sql = "select boaid,boaname, boauname, boaflag from bbsboard where boaflag = '1'";
		ResultSet rs = DBManager.queryDb(sql);
		return rs;
	}
}
