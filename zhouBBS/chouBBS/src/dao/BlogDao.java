package com.sxt.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.sxt.bbs.bean.BlogBean;
import com.sxt.bbs.util.DBManager;

public class BlogDao {
	private static QueryRunner qr = new QueryRunner(DBManager.getDataSource());
	/**
	 * 获得某个子版块下所有帖子
	 * 
	 * @param cboid
	 * @return
	 */
	public static ResultSet getBlog(String cboid) {
		String sql = "SELECT b.bloid, blotitle, uname, cnt FROM bbsblog b "
				+ "LEFT JOIN ( "
				+ "SELECT bloid, COUNT(rblid) cnt FROM bbsreplyblog "
				+ "WHERE rblisdelete = '0' " + "GROUP BY bloid "
				+ ") rb ON b.bloid = rb.bloid " + "WHERE cboid = '" + cboid
				+ "' AND bloisdelete = '0'";
		return DBManager.queryDb(sql);
	}
	
	/**
	 * 通过帖子id获得帖子
	 * @param id
	 * @return
	 */
	public static ResultSet getBlogById(int id) {
		String sql = "select * from bbsblog where bloid = '" + id + "';";
		return DBManager.queryDb(sql);
	}
	
	/**
	 * 添加帖子
	 * @param bb
	 * @return
	 * @throws SQLException
	 */
	public static int addBlog(BlogBean bb) throws SQLException {
		String sql = "insert into bbsblog values (null, ?, ?, ?, ?, ?, ?, ?, ? ,'0')";
		return qr.update(sql, bb.getBlotitle(), bb.getBlocontent(), bb.getBloinputdate(), bb.getBloinputtime(), bb.getBlolastmodifydate(), bb.getBlolastmodifytime(), bb.getUname(), bb.getChoid());
	}

}
