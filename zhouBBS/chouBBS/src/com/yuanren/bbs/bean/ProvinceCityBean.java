package com.sxt.bbs.bean;

public class ProvinceCityBean {
	private String id;
	private String name;

	public ProvinceCityBean() {
		super();
	}

	public ProvinceCityBean(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProvinceCityBean [id=" + id + ", name=" + name + "]";
	}

}
