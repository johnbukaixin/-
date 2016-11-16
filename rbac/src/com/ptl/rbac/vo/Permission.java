package com.ptl.rbac.vo;

import java.util.ArrayList;
import java.util.List;

public class Permission implements Comparable<Permission>{
	private int id;
	private String name;
	private String url;
	private int sort;
	private int pid;
	private String type;
	private String percode;
	private List<Permission> children=new ArrayList<Permission>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<Permission> getChildren() {
		return children;
	}
	public void setChildren(List<Permission> children) {
		this.children = children;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPercode() {
		return percode;
	}
	public void setPercode(String percode) {
		this.percode = percode;
	}
	@Override
	public int compareTo(Permission o) {
		return this.sort-o.getSort();
	}
}
