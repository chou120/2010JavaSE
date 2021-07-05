package com.sxt.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.sxt.bbs.bean.ReplyBlogBean;
import com.sxt.bbs.util.DBManager;

public class ReplyBlogDao {
	private static QueryRunner qr = new QueryRunner(DBManager.getDataSource());

	/**
	 * 通过主题编号获取回复信息
	 * 
	 * @param bloid
	 * @return
	 */
	public static ResultSet getReplyBlog(String bloid, int pageNow, int pageSize) {
		String sql = "select * from bbsreplyblog where bloid = '" + bloid
				+ "' and rblisdelete = '0' limit " + (pageNow - 1) * pageSize
				+ "," + pageSize + ";";
		return DBManager.queryDb(sql);
	}

	/**
	 * 添加回复贴
	 * 
	 * @param rbb
	 * @return
	 * @throws SQLException
	 */
	public static int addReply(ReplyBlogBean rbb) throws SQLException {
		String sql = "insert into bbsreplyblog values (null, ?, ?, ?, ?, ?, ?, ?, '0');";
		return qr.update(sql, rbb.getRblcontent(), rbb.getRblreplydate(),
				rbb.getRblreplytime(), rbb.getRblmodifydate(),
				rbb.getRblmodifytime(), rbb.getUname(), rbb.getBloid());
	}
	
	/**
	 * 查询记录数
	 * @param bloid
	 * @return
	 */
	public static int replyCount(String bloid) {
		String sql = "select count(*) from bbsreplyblog where bloid = " + bloid;
		ResultSet rs  = DBManager.queryDb(sql);
		try {
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close();
		}
		return 0;
	}
}
