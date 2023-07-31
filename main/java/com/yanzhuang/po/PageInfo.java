package com.yanzhuang.po;

import java.util.List;

public class PageInfo 
{
	private int totalinfo;
	private int page;
	private int tuple;
	List<Object> rows;
	public PageInfo()
	{
		
	}
	public PageInfo(int totalinfo,int tuple)
	{
		this.totalinfo=totalinfo;
		this.tuple=tuple;
		this.page=totalinfo/tuple+1;
	}
	public int getTotalinfo() {
		return totalinfo;
	}
	public void setTotalinfo(int totalinfo) {
		this.totalinfo = totalinfo;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTuple() {
		return tuple;
	}
	public void setTuple(int tuple) {
		this.tuple = tuple;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
}
