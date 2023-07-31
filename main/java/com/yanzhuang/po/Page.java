package com.yanzhuang.po;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Page 
{
	private int totalinfo;
	private int tuple;
	private int page;
	private int pagenum;
	private List<Object> rows;
	private String tablename;
	private HashMap<String,String> hm=new HashMap<String,String>();
	public String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	public Page()
	{
		
	}
	public Page(int totalinfo, int tuple, List<Object> rows,String tablename) {
		super();
		this.totalinfo = totalinfo;
		this.tuple = tuple;
		if(totalinfo%tuple==0)
		{
			this.page = totalinfo/tuple;
		}
		else
		{
			this.page = totalinfo/tuple+1;
		}
		this.rows = rows;
		this.hm.put(tablename, this.uuid);
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public HashMap<String, String> getHm() {
		return hm;
	}
	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public int getTotalinfo() {
		return totalinfo;
	}
	public void setTotalinfo(int totalinfo) {
		this.totalinfo = totalinfo;
	}
	public int getTuple() {
		return tuple;
	}
	public void setTuple(int tuple) {
		this.tuple = tuple;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public List<Object> getRows() {
		return rows;
	}
	public void setRows(List<Object> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Page [totalinfo=" + totalinfo + ", tuple=" + tuple + ", page=" + page + ", pagenum=" + pagenum
				+ ", rows=" + rows +", uuid=" + uuid+ "]";
	}
	public void put(String tablename)
	{
		this.hm.put(tablename, this.uuid);
	}
	public void remove(String tablename)
	{
		this.hm.remove(tablename);
	}
	public  List<Object> getInfo(String tablename,int pagenum)
	{
		Storage storage=Storage.getStorage();
		List<Object> infos=null;
		if(hm.get(tablename)!=null){
			String id=hm.get(tablename);
			infos=storage.get(id).rows;
		}
		else
		{
			infos=storage.get(uuid).rows;
		}
		if(pagenum>this.page||pagenum<=0) 
		{
		pagenum=1;
		}
		int startnum=tuple*(pagenum-1)-1;
		int endnum=tuple*pagenum-1;
		List<Object> lists=new ArrayList<Object>();
		if(startnum<0)
		{
			startnum=0;
		}
		if(rows.size()-1<endnum)
		{
			endnum=rows.size()-1;
		}
		for(int i=startnum;i<=endnum;i++)
		{
			lists.add(infos.get(i));
		}
		return lists;
		
	}
	
}
