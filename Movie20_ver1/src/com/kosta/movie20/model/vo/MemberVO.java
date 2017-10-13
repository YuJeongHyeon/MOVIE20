package com.kosta.movie20.model.vo;

import java.util.ArrayList;

public class MemberVO {
	private ArrayList<MovieVO> cart = new ArrayList<MovieVO>();
	private String id;
	private String name;
	private String password;
	private String nick;
	private String address;
	private String birthday;
	private String tel;
	private String favoriteGenre;
	private String authority;
	public MemberVO() {
		super();
	}
	public MemberVO(ArrayList<MovieVO> cart, String id, String name, String password, String nick, String address,
			String birthday, String tel, String favoriteGenre, String authority) {
		super();
		this.cart = cart;
		this.id = id;
		this.name = name;
		this.password = password;
		this.nick = nick;
		this.address = address;
		this.birthday = birthday;
		this.tel = tel;
		this.favoriteGenre = favoriteGenre;
		this.authority = authority;
	}
	public ArrayList<MovieVO> getCart() {
		return cart;
	}
	public void setCart(ArrayList<MovieVO> cart) {
		this.cart = cart;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFavoriteGenre() {
		return favoriteGenre;
	}
	public void setFavoriteGenre(String favoriteGenre) {
		this.favoriteGenre = favoriteGenre;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "MemberVO [cart=" + cart + ", id=" + id + ", name=" + name + ", password=" + password + ", nick=" + nick
				+ ", address=" + address + ", birthday=" + birthday + ", tel=" + tel + ", favoriteGenre="
				+ favoriteGenre + ", authority=" + authority + "]";
	}


}
