package com.sxt.bbs.bean;

/**
 * @author LiangJie
 *
 */
public class ReplyBlogBean {
	private int rblid;
	private String rblcontent;
	private String rblreplydate;
	private String rblreplytime;
	private String rblmodifydate;
	private String rblmodifytime;
	private String uname;
	private UserBean userbean;
	private int bloid;
	private String rblisdelete;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public ReplyBlogBean(int rblid, String rblcontent, String rblreplydate,
			String rblreplytime, String rblmodifydate, String rblmodifytime,
			String uname, UserBean userbean, int bloid, String rblisdelete) {
		super();
		this.rblid = rblid;
		this.rblcontent = rblcontent;
		this.rblreplydate = rblreplydate;
		this.rblreplytime = rblreplytime;
		this.rblmodifydate = rblmodifydate;
		this.rblmodifytime = rblmodifytime;
		this.uname = uname;
		this.userbean = userbean;
		this.bloid = bloid;
		this.rblisdelete = rblisdelete;
	}

	public ReplyBlogBean() {
		super();
	}

	public ReplyBlogBean(int rblid, String rblcontent, String rblreplydate,
			String rblreplytime, String rblmodifydate, String rblmodifytime,
			UserBean userbean, int bloid, String rblisdelete) {
		super();
		this.rblid = rblid;
		this.rblcontent = rblcontent;
		this.rblreplydate = rblreplydate;
		this.rblreplytime = rblreplytime;
		this.rblmodifydate = rblmodifydate;
		this.rblmodifytime = rblmodifytime;
		this.userbean = userbean;
		this.bloid = bloid;
		this.rblisdelete = rblisdelete;
	}

	public int getRblid() {
		return rblid;
	}

	public void setRblid(int rblid) {
		this.rblid = rblid;
	}

	public String getRblcontent() {
		return rblcontent;
	}

	public void setRblcontent(String rblcontent) {
		this.rblcontent = rblcontent;
	}

	public String getRblreplydate() {
		return rblreplydate;
	}

	public void setRblreplydate(String rblreplydate) {
		this.rblreplydate = rblreplydate;
	}

	public String getRblreplytime() {
		return rblreplytime;
	}

	public void setRblreplytime(String rblreplytime) {
		this.rblreplytime = rblreplytime;
	}

	public String getRblmodifydate() {
		return rblmodifydate;
	}

	public void setRblmodifydate(String rblmodifydate) {
		this.rblmodifydate = rblmodifydate;
	}

	public String getRblmodifytime() {
		return rblmodifytime;
	}

	public void setRblmodifytime(String rblmodifytime) {
		this.rblmodifytime = rblmodifytime;
	}

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	public int getBloid() {
		return bloid;
	}

	public void setBloid(int bloid) {
		this.bloid = bloid;
	}

	public String getRblisdelete() {
		return rblisdelete;
	}

	public void setRblisdelete(String rblisdelete) {
		this.rblisdelete = rblisdelete;
	}

	@Override
	public String toString() {
		return "ReplyBlogBean [rblid=" + rblid + ", rblcontent=" + rblcontent
				+ ", rblreplydate=" + rblreplydate + ", rblreplytime="
				+ rblreplytime + ", rblmodifydate=" + rblmodifydate
				+ ", rblmodifytime=" + rblmodifytime + ", uname=" + uname
				+ ", userbean=" + userbean + ", bloid=" + bloid
				+ ", rblisdelete=" + rblisdelete + "]";
	}

}
