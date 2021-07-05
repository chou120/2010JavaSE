package com.sxt.bbs.bean;

public class PageBean {
	private int pageNow;
	private int pageSize;
	private int pageTotal;
	private int RecordTotal;

	public PageBean() {
		super();
	}

	public PageBean(int pageNow, int pageSize, int pageTotal, int recordTotal) {
		super();
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		RecordTotal = recordTotal;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getRecordTotal() {
		return RecordTotal;
	}

	public void setRecordTotal(int recordTotal) {
		RecordTotal = recordTotal;
	}

	@Override
	public String toString() {
		return "PageBean [pageNow=" + pageNow + ", pageSize=" + pageSize
				+ ", pageTotal=" + pageTotal + ", RecordTotal=" + RecordTotal
				+ "]";
	}

}
