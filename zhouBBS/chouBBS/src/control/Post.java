package com.sxt.bbs.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.bbs.bean.BlogBean;
import com.sxt.bbs.dao.BlogDao;
import com.sxt.bbs.util.DBManager;

public class Post extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cboid = request.getParameter("cboid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String uname = request.getSession().getAttribute("uname").toString();
		if (uname != null && !uname.isEmpty()) {
			BlogBean bb = new BlogBean();
			bb.setBlotitle(title);
			bb.setBlocontent(content);
			String date = new Date(new java.util.Date().getTime()).toString();
			String time = new Time(new java.util.Date().getTime()).toString();
			bb.setBloinputdate(date);
			bb.setBloinputtime(time);
			bb.setBlolastmodifydate(date);
			bb.setBlolastmodifytime(time);
			bb.setUname(uname);
			bb.setChoid(cboid);
			
			try {
				BlogDao.addBlog(bb);
				response.sendRedirect("list?cboid="+cboid);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
