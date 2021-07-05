package com.sxt.bbs.bean;

/**
 * 主题帖实体类
 * 
 * @author LiangJie
 *
 */
public class BlogBean {
	private int bloid;
	private String blotitle;
	private String blocontent;
	private String bloinputdate;
	private String bloinputtime;
	private String blolastmodifydate;
	private String blolastmodifytime;
	private String uname;
	private UserBean userbean;
	private String choid;
	private String bloisdelete;
	private int replyCount;

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	public BlogBean(int bloid, String blotitle, String blocontent,
			String bloinputdate, String bloinputtime, String blolastmodifydate,
			String blolastmodifytime, String uname, UserBean userbean,
			String choid, String bloisdelete, int replyCount) {
		super();
		this.bloid = bloid;
		this.blotitle = blotitle;
		this.blocontent = blocontent;
		this.bloinputdate = bloinputdate;
		this.bloinputtime = bloinputtime;
		this.blolastmodifydate = blolastmodifydate;
		this.blolastmodifytime = blolastmodifytime;
		this.uname = uname;
		this.userbean = userbean;
		this.choid = choid;
		this.bloisdelete = bloisdelete;
		this.replyCount = replyCount;
	}

	public BlogBean(int bloid, String blotitle, String blocontent,
			String bloinputdate, String bloinputtime, String blolastmodifydate,
			String blolastmodifytime, String uname, String choid,
			String bloisdelete, int replyCount) {
		super();
		this.bloid = bloid;
		this.blotitle = blotitle;
		this.blocontent = blocontent;
		this.bloinputdate = bloinputdate;
		this.bloinputtime = bloinputtime;
		this.blolastmodifydate = blolastmodifydate;
		this.blolastmodifytime = blolastmodifytime;
		this.uname = uname;
		this.choid = choid;
		this.bloisdelete = bloisdelete;
		this.replyCount = replyCount;
	}

	public BlogBean() {
		super();
	}

	public int getBloid() {
		return bloid;
	}

	public void setBloid(int bloid) {
		this.bloid = bloid;
	}

	public String getBlotitle() {
		return blotitle;
	}

	public void setBlotitle(String blotitle) {
		this.blotitle = blotitle;
	}

	public String getBlocontent() {
		return blocontent;
	}

	public void setBlocontent(String blocontent) {
		this.blocontent = blocontent;
	}

	public String getBloinputdate() {
		return bloinputdate;
	}

	public void setBloinputdate(String bloinputdate) {
		this.bloinputdate = bloinputdate;
	}

	public String getBloinputtime() {
		return bloinputtime;
	}

	public void setBloinputtime(String bloinputtime) {
		this.bloinputtime = bloinputtime;
	}

	public String getBlolastmodifydate() {
		return blolastmodifydate;
	}

	public void setBlolastmodifydate(String blolastmodifydate) {
		this.blolastmodifydate = blolastmodifydate;
	}

	public String getBlolastmodifytime() {
		return blolastmodifytime;
	}

	public void setBlolastmodifytime(String blolastmodifytime) {
		this.blolastmodifytime = blolastmodifytime;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getChoid() {
		return choid;
	}

	public void setChoid(String choid) {
		this.choid = choid;
	}

	public String getBloisdelete() {
		return bloisdelete;
	}

	public void setBloisdelete(String bloisdelete) {
		this.bloisdelete = bloisdelete;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "BlogBean [bloid=" + bloid + ", blotitle=" + blotitle
				+ ", blocontent=" + blocontent + ", bloinputdate="
				+ bloinputdate + ", bloinputtime=" + bloinputtime
				+ ", blolastmodifydate=" + blolastmodifydate
				+ ", blolastmodifytime=" + blolastmodifytime + ", uname="
				+ uname + ", userbean=" + userbean + ", choid=" + choid
				+ ", bloisdelete=" + bloisdelete + ", replyCount=" + replyCount
				+ "]";
	}

}
