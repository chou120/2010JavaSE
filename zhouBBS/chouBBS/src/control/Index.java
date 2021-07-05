package com.sxt.bbs.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.bbs.bean.BlogBean;
import com.sxt.bbs.bean.BoardBean;
import com.sxt.bbs.bean.ChildBoardBean;
import com.sxt.bbs.dao.BoardDao;
import com.sxt.bbs.dao.ChildBoardDao;
import com.sxt.bbs.util.DBManager;

public class Index extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResultSet rs = BoardDao.getBoard();
		ResultSet crs = ChildBoardDao.getChildBoard();
		List<BoardBean> list = new ArrayList<BoardBean>(); // Board
		List<ChildBoardBean> list2 = new ArrayList<ChildBoardBean>(); // ChildBoard
		try {
			while (rs.next()) {
				BoardBean bb = new BoardBean();
				bb.setBoaid(rs.getString("boaid"));
				bb.setBoaname(rs.getString("boaname"));
				bb.setBoauname(rs.getString("boauname"));
				list.add(bb);
			}

			while (crs.next()) {
				ChildBoardBean cbb = new ChildBoardBean();
				cbb.setCboid(crs.getString("cboid"));
				cbb.setCboname(crs.getString("cboname"));
				cbb.setBlogCount(crs.getString("cnt"));
				cbb.setBoaid(crs.getString("boaid"));
				BlogBean blog = new BlogBean();
				blog.setBloid(crs.getInt("bloid"));
				blog.setBlotitle(crs.getString("blotitle"));
				blog.setBloinputdate(crs.getString("bloinputdate"));
				blog.setBloinputtime(crs.getString("bloinputtime"));
				blog.setUname(crs.getString("uname"));
				cbb.setBlog(blog);
				list2.add(cbb);
			}
			//System.out.println(list2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close();
		}

		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
