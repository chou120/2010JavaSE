package com.sxt.bbs.bean;

/**
 * 用户实体类
 * 
 * @author LiangJie
 *
 */
public class UserBean {
	private String uname;
	private String upass;
	private String uproc;
	private String ucity;
	private String usex;
	private String uphoto;
	private String uregdate;
	private String uregtime;
	private String uisadmin;
	private String uflag;

	public UserBean() {
	}

	public UserBean(String uname, String upass, String uproc, String ucity,
			String usex, String uphoto, String uregdate, String uregtime,
			String uisadmin, String uflag) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.uproc = uproc;
		this.ucity = ucity;
		this.usex = usex;
		this.uphoto = uphoto;
		this.uregdate = uregdate;
		this.uregtime = uregtime;
		this.uisadmin = uisadmin;
		this.uflag = uflag;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUproc() {
		return uproc;
	}

	public void setUproc(String uproc) {
		this.uproc = uproc;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUphoto() {
		return uphoto;
	}

	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}

	public String getUregdate() {
		return uregdate;
	}

	public void setUregdate(String uregdate) {
		this.uregdate = uregdate;
	}

	public String getUregtime() {
		return uregtime;
	}

	public void setUregtime(String uregtime) {
		this.uregtime = uregtime;
	}

	public String getUisadmin() {
		return uisadmin;
	}

	public void setUisadmin(String uisadmin) {
		this.uisadmin = uisadmin;
	}

	public String getUflag() {
		return uflag;
	}

	public void setUflag(String uflag) {
		this.uflag = uflag;
	}

	@Override
	public String toString() {
		return "UserBean [uname=" + uname + ", upass=" + upass + ", uproc="
				+ uproc + ", ucity=" + ucity + ", usex=" + usex + ", uphoto="
				+ uphoto + ", uregdate=" + uregdate + ", uregtime=" + uregtime
				+ ", uisadmin=" + uisadmin + ", uflag=" + uflag + "]";
	}

}
