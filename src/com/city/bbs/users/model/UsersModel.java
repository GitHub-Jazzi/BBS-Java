package com.city.bbs.users.model;

public class UsersModel {
	private String mail;
	private String password;
	private byte[] pic;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] bs) {
		this.pic = bs;
	}
	
	
}
