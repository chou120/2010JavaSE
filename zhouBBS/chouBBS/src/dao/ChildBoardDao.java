package com.sxt.bbs.dao;

import java.sql.ResultSet;

import com.sxt.bbs.util.DBManager;

public class ChildBoardDao {
	public static ResultSet getChildBoard() {
		String sql = "SELECT cb.cboid,cboname,cnt,boaid,bloid,blotitle,bloinputdate,bloinputtime,uname "
				+ "FROM bbschildboard cb "
				+ "LEFT JOIN ( "
				+ "SELECT *, COUNT(bloid) cnt FROM ( "
				+ "SELECT bloid, blotitle, bloinputdate, bloinputtime, uname, cboid "
				+ "FROM bbsblog "
				+ "WHERE bloisdelete='0' "
				+ "ORDER BY bloinputdate DESC, bloinputtime DESC "
				+ ") t GROUP BY cboid "
				+ ") t2 ON cb.cboid = t2.cboid "
				+ "WHERE cboflag = '1';";
		return DBManager.queryDb(sql);
	}
}
