package com.sxt.bbs.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.bbs.bean.BlogBean;
import com.sxt.bbs.dao.BlogDao;
import com.sxt.bbs.util.DBManager;

public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cboid = request.getParameter("cboid");
		String cboname = request.getParameter("cboname");
		if (cboid != null & !cboid.trim().isEmpty()) {
			java.util.List<BlogBean> list = new ArrayList<BlogBean>();
			ResultSet rs = BlogDao.getBlog(cboid);
			try {
				while (rs.next()) {
					BlogBean bb = new BlogBean();
					bb.setBloid(rs.getInt("bloid"));
					bb.setBlotitle(rs.getString("blotitle"));
					bb.setUname(rs.getString("uname"));
					bb.setReplyCount(rs.getInt("cnt"));
					list.add(bb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close();
			}
			request.setAttribute("cboid", cboid);
			request.setAttribute("cboname", cboname);
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
