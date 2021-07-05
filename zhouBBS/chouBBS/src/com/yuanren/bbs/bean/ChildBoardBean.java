package com.sxt.bbs.bean;

/**
 * 子版块实体类
 * @author LiangJie
 *
 */
/**
 * @author LiangJie
 *
 */
public class ChildBoardBean {
	private String cboid;
	private String cboname;
	private String boaid;
	private String cbodate;
	private String chotime;
	private String cboflag;
	private String blogCount;
	private BlogBean blog;

	public ChildBoardBean(String cboid, String cboname, String boaid,
			String cbodate, String chotime, String cboflag, String blogCount,
			BlogBean blog) {
		super();
		this.cboid = cboid;
		this.cboname = cboname;
		this.boaid = boaid;
		this.cbodate = cbodate;
		this.chotime = chotime;
		this.cboflag = cboflag;
		this.blogCount = blogCount;
		this.blog = blog;
	}

	public BlogBean getBlog() {
		return blog;
	}

	public void setBlog(BlogBean blog) {
		this.blog = blog;
	}

	public ChildBoardBean(String cboid, String cboname, String boaid,
			String cbodate, String chotime, String cboflag, String blogCount) {
		super();
		this.cboid = cboid;
		this.cboname = cboname;
		this.boaid = boaid;
		this.cbodate = cbodate;
		this.chotime = chotime;
		this.cboflag = cboflag;
		this.blogCount = blogCount;
	}

	public String getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(String blogCount) {
		this.blogCount = blogCount;
	}

	public ChildBoardBean() {
	}

	public ChildBoardBean(String cboid, String cboname, String boaid,
			String cbodate, String chotime, String cboflag) {
		super();
		this.cboid = cboid;
		this.cboname = cboname;
		this.boaid = boaid;
		this.cbodate = cbodate;
		this.chotime = chotime;
		this.cboflag = cboflag;
	}

	public String getCboid() {
		return cboid;
	}

	public void setCboid(String cboid) {
		this.cboid = cboid;
	}

	public String getCboname() {
		return cboname;
	}

	public void setCboname(String cboname) {
		this.cboname = cboname;
	}

	public String getBoaid() {
		return boaid;
	}

	public void setBoaid(String boaid) {
		this.boaid = boaid;
	}

	public String getCbodate() {
		return cbodate;
	}

	public void setCbodate(String cbodate) {
		this.cbodate = cbodate;
	}

	public String getChotime() {
		return chotime;
	}

	public void setChotime(String chotime) {
		this.chotime = chotime;
	}

	public String getCboflag() {
		return cboflag;
	}

	public void setCboflag(String cboflag) {
		this.cboflag = cboflag;
	}

	@Override
	public String toString() {
		return "ChildBoardBean [cboid=" + cboid + ", cboname=" + cboname
				+ ", boaid=" + boaid + ", cbodate=" + cbodate + ", chotime="
				+ chotime + ", cboflag=" + cboflag + ", blogCount=" + blogCount
				+ ", blog=" + blog + "]";
	}

}
