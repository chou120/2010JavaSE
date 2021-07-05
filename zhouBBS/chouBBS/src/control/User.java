package com.sxt.bbs.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.bbs.bean.UserBean;
import com.sxt.bbs.dao.UserDao;
import com.sxt.bbs.util.DBManager;
import com.sxt.bbs.util.MD5;

public class User extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uName");
		String upass = request.getParameter("uPass");
		String province = request.getParameter("province");
		String sex = request.getParameter("gender");
		String city = request.getParameter("city");
		String head = request.getParameter("head");

		if (uname != null && !uname.trim().isEmpty() && upass != null
				&& !upass.trim().isEmpty()) {
			UserBean ub = new UserBean();
			ub.setUname(uname);
			ub.setUpass(MD5.md5Encode(upass));
			ub.setUsex(Integer.parseInt(sex) == 2 ? "女" : "男");
			ub.setUphoto(head);
			ub.setUregdate(new Date(new java.util.Date().getTime()).toString());
			ub.setUregtime(new Time(new java.util.Date().getTime()).toString());
			ub.setUproc(province);
			ub.setUcity(city);
			ub.setUisadmin("0");
			ub.setUflag("0");
			int result = 0;
			try {
				result = UserDao.add(ub);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close();
			}
			
			if (result == 1) {
				request.getSession().setAttribute("uname", ub.getUname());
				response.sendRedirect("index");
			}
		}
	}

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uName");
		String upass = request.getParameter("uPass");
		if (uname != null && !uname.trim().isEmpty() && upass != null
				&& !upass.trim().isEmpty()) {
			UserBean ub = UserDao.searchByUname(request.getParameter("uName"));
			if (ub != null) {
				if (ub.getUpass().equals(MD5.md5Encode(upass))) {
					request.getSession().setAttribute("uname", ub.getUname());
					response.sendRedirect("index");
				} else {
					response.sendRedirect("login.jsp?error=passerror");
				}
			} else {
				response.sendRedirect("login.jsp?error=usererror");
			}
		} else {
			response.sendRedirect("login.jsp?error=paramerror");
		} 
		DBManager.close();
	}
	
	public static void safeExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("uname");
		response.sendRedirect("index");
	}

}
