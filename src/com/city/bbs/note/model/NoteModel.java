package com.city.bbs.note.model;

import java.util.Date;

public class NoteModel {
	private int id;
	private int module_id;
	private int up_id;
	private String title;
	private String cont;
	private Date time;
	private String user_name;
	private String m_color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public int getUp_id() {
		return up_id;
	}
	public void setUp_id(int up_id) {
		this.up_id = up_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getM_color() {
		return m_color;
	}
	public void setM_color(String m_color) {
		this.m_color = m_color;
	}
	
	
}
