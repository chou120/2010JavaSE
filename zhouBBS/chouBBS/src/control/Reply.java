package com.sxt.bbs.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.bbs.bean.ReplyBlogBean;
import com.sxt.bbs.dao.ReplyBlogDao;
import com.sxt.bbs.util.DBManager;

public class Reply extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bloid = Integer.parseInt(request.getParameter("bloid").toString());
		String content = request.getParameter("content");
		ReplyBlogBean rbb = new ReplyBlogBean();
		String cboname = request.getParameter("cboname");
		request.getSession().setAttribute("cboname", cboname);
		
		rbb.setRblcontent(content);
		String date = new Date(new java.util.Date().getTime()).toString();
		String time = new Time(new java.util.Date().getTime()).toString();
		rbb.setRblreplydate(date);
		rbb.setRblreplytime(time);
		rbb.setRblmodifydate(date);
		rbb.setRblmodifytime(time);
		rbb.setUname(request.getSession().getAttribute("uname").toString());
		rbb.setBloid(bloid);
		
		try {
			ReplyBlogDao.addReply(rbb);
			response.sendRedirect("detail?bloid=" + bloid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
