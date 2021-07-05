package com.sxt.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.sxt.bbs.bean.UserBean;
import com.sxt.bbs.util.DBManager;

public class UserDao {
	private static QueryRunner qr = new QueryRunner(DBManager.getDataSource());

	/**
	 * 添加用户
	 * 
	 * @param ub
	 * @return
	 * @throws SQLException
	 */
	public static int add(UserBean ub) throws SQLException {
		String sql = "insert into bbsuser values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		return qr.update(sql, ub.getUname(), ub.getUpass(),
				ub.getUproc(), ub.getUcity(), ub.getUsex(), ub.getUphoto(),
				ub.getUregdate(), ub.getUregtime(), ub.getUisadmin(),
				ub.getUflag());
	}

	/**
	 * 删除用户
	 * 
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public static int delete(String uname) throws SQLException {
		String sql = "delete from bbsuser where uname = ?";
		return qr.update(sql, uname);
	}

	/**
	 * 修改用户信息
	 * 
	 * @param ub
	 * @return
	 * @throws SQLException
	 */
	public static int update(UserBean ub) throws SQLException {
		String sql = "update bbsuser set upass = ?, uproc = ?, ucity = ?, usex = ?, uphoto = ?, uregdate = ?, uregtime = ?, uisadmin = ?, uflag = ?";
		return qr.update(sql, ub.getUpass(), ub.getUproc(), ub.getUcity(),
				ub.getUsex(), ub.getUregdate(), ub.getUregtime(),
				ub.getUisadmin(), ub.getUflag());
	}

	/**
	 * 通过用户名查询用户，用户登录
	 * @param uname
	 * @return
	 */
	public static UserBean searchByUname(String uname) {
		String sql = "select * from bbsuser where uname = '" + uname + "';";
		ResultSet rs = DBManager.queryDb(sql);
		UserBean ub = null;
		try {
			if (rs.next()) {
				ub = new UserBean();
				ub.setUname(rs.getString("uname"));
				ub.setUpass(rs.getString("upass"));
				ub.setUproc(rs.getString("uproc"));
				ub.setUcity(rs.getString("ucity"));
				ub.setUsex(rs.getString("usex"));
				ub.setUphoto(rs.getString("uphoto"));
				ub.setUregdate(rs.getString("uregdate"));
				ub.setUregtime(rs.getString("uregtime"));
				ub.setUisadmin(rs.getString("uisadmin"));
				ub.setUflag(rs.getString("uflag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close();
		}
		return ub;
	}
}
