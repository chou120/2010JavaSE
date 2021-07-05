package com.sxt.bbs.bean;

/**
 * 板块实体类
 * 
 * @author LiangJie
 *
 */
public class BoardBean {
	private String boaid;
	private String boaname;
	private String boauname;
	private String boadate;
	private String boatime;
	private String boaflag;

	public BoardBean() {
	}

	public BoardBean(String boaid, String boaname, String boauname,
			String boadate, String boatime, String boaflag) {
		super();
		this.boaid = boaid;
		this.boaname = boaname;
		this.boauname = boauname;
		this.boadate = boadate;
		this.boatime = boatime;
		this.boaflag = boaflag;
	}

	public String getBoaid() {
		return boaid;
	}

	public void setBoaid(String boaid) {
		this.boaid = boaid;
	}

	public String getBoaname() {
		return boaname;
	}

	public void setBoaname(String boaname) {
		this.boaname = boaname;
	}

	public String getBoauname() {
		return boauname;
	}

	public void setBoauname(String boauname) {
		this.boauname = boauname;
	}

	public String getBoadate() {
		return boadate;
	}

	public void setBoadate(String boadate) {
		this.boadate = boadate;
	}

	public String getBoatime() {
		return boatime;
	}

	public void setBoatime(String boatime) {
		this.boatime = boatime;
	}

	public String getBoaflag() {
		return boaflag;
	}

	public void setBoaflag(String boaflag) {
		this.boaflag = boaflag;
	}

	@Override
	public String toString() {
		return "BoardBean [boaid=" + boaid + ", boaname=" + boaname
				+ ", boauname=" + boauname + ", boadate=" + boadate
				+ ", boatime=" + boatime + ", boaflag=" + boaflag + "]";
	}

}
