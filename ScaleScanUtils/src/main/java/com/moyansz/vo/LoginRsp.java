package com.moyansz.vo;

import java.util.List;

public class LoginRsp extends BaseRsp {

	private static final long serialVersionUID = -2842628657634773716L;

	// 某个对象
	private Account obj;

	private String string;
	// 凭证
	private String key;

	/**
	 * 用户可以访问的菜单地址列表
	 */
	private List<String> menuList;

	/**
	 * 所有菜单地址列表
	 */
	private List<String> allMenuList;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Account getObj() {
		return obj;
	}

	public void setObj(Account obj) {
		this.obj = obj;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<String> menuList) {
		this.menuList = menuList;
	}

	public List<String> getAllMenuList() {
		return allMenuList;
	}

	public void setAllMenuList(List<String> allMenuList) {
		this.allMenuList = allMenuList;
	}

}
