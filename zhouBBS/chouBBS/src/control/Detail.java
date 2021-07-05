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
import com.sxt.bbs.bean.ReplyBlogBean;
import com.sxt.bbs.bean.UserBean;
import com.sxt.bbs.dao.BlogDao;
import com.sxt.bbs.dao.ReplyBlogDao;
import com.sxt.bbs.dao.UserDao;
import com.sxt.bbs.util.DBManager;

public class Detail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cboid = request.getParameter("cboid");
		String bloid = request.getParameter("bloid");
		String cboname = request.getParameter("cboname");

		int pageSize = 3;
		try {
			pageSize = Integer.parseInt(getServletContext().getInitParameter(
					"replyBlogPageSize").toString());
		} catch (Exception e) {
			pageSize = 3;
		}

		int pageNow = 1;
		try {
			pageNow = Integer.parseInt(request.getParameter("pageNow"));
		} catch (Exception e) {
			pageNow = 1;
		}

		int recordTotal = ReplyBlogDao.replyCount(bloid);
		int pageTotal = recordTotal % pageSize == 0 ? recordTotal / pageSize
				: recordTotal / pageSize + 1;

		if (bloid != null && !bloid.trim().isEmpty()) {
			ResultSet rs = ReplyBlogDao.getReplyBlog(bloid, pageNow, pageSize);
			List<ReplyBlogBean> list = new ArrayList<ReplyBlogBean>();
			try {
				while (rs.next()) {
					ReplyBlogBean rbb = new ReplyBlogBean();
					rbb.setRblid(rs.getInt("rblid"));
					rbb.setRblcontent(rs.getString("rblcontent"));
					rbb.setRblreplydate(rs.getString("rblreplydate"));
					rbb.setRblreplytime(rs.getString("rblreplytime"));
					rbb.setRblmodifydate(rs.getString("rblmodifydate"));
					rbb.setRblmodifytime(rs.getString("rblmodifytime"));
					rbb.setRblisdelete(rs.getString("rblisdelete"));

					UserBean ub = UserDao.searchByUname(rs.getString("uname"));
					rbb.setUserbean(ub);
					list.add(rbb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close();
			}

			ResultSet brs = BlogDao.getBlogById(Integer.parseInt(bloid));
			BlogBean bb = new BlogBean();
			try {
				brs.next();
				UserBean ub = UserDao.searchByUname(brs.getString("uname"));
				bb.setBloid(Integer.parseInt(bloid));
				bb.setUserbean(ub);
				bb.setBlotitle(brs.getString("blotitle"));
				bb.setBlocontent(brs.getString("blocontent"));
				bb.setBloinputdate(brs.getString("bloinputdate"));
				bb.setBloinputtime(brs.getString("bloinputtime"));
				bb.setBlolastmodifydate(brs.getString("blolastmodifydate"));
				bb.setBlolastmodifytime(brs.getString("blolastmodifytime"));
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close();
			}
			request.setAttribute("cboid", cboid);
			request.setAttribute("cboname", cboname);
			request.setAttribute("blogbean", bb);
			request.setAttribute("list", list);
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("pageTotal", pageTotal);
			request.setAttribute("recordTotal", recordTotal);
			request.getRequestDispatcher("detail.jsp").forward(request,
					response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
