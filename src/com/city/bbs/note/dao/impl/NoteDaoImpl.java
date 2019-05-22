package com.city.bbs.note.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.city.bbs.note.dao.INoteDao;
import com.city.bbs.note.model.NoteModel;
import com.city.bbs.users.factory.DaoFactory;
import com.city.bbs.users.model.UsersModel;

public class NoteDaoImpl implements INoteDao {

	@Override
	public List<NoteModel> query(int id) {
		String sql="select * from note where module_id =?";
		NoteModel o=null;
		List<NoteModel> v=new ArrayList<NoteModel>();
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				o=new NoteModel();
				o.setId(rs.getInt("id"));
				o.setModule_id(rs.getInt("module_id"));
				o.setUp_id(rs.getInt("up_id"));
				o.setTitle(rs.getString("title"));
				o.setCont(rs.getString("cont"));
				o.setTime(rs.getDate("time"));
				o.setUser_name(rs.getString("user_name"));
				o.setM_color(rs.getString("m_color"));
				v.add(o);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public int numOfNotes() {
		String sql="select count(*) from note";
		int num=0;
		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet res=ps.executeQuery();
			res.next();
			num=res.getInt(1);
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}

	@Override
	public NoteModel oneOfNote(int id) {
		String sql="select * from note where id =?";
		NoteModel o=new NoteModel();
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				o.setId(rs.getInt("id"));
				o.setModule_id(rs.getInt("module_id"));
				o.setUp_id(rs.getInt("up_id"));
				o.setTitle(rs.getString("title"));
				o.setCont(rs.getString("cont"));
				o.setTime(rs.getDate("time"));
				o.setUser_name(rs.getString("user_name"));
				o.setM_color(rs.getString("m_color"));
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public List<NoteModel> queryFromUpId(int up_id) {
		String sql="select * from note where up_id =?";
		NoteModel o=null;
		List<NoteModel> v=new ArrayList<NoteModel>();
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, up_id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				o=new NoteModel();
				o.setId(rs.getInt("id"));
				o.setModule_id(rs.getInt("module_id"));
				o.setUp_id(rs.getInt("up_id"));
				o.setTitle(rs.getString("title"));
				o.setCont(rs.getString("cont"));
				o.setTime(rs.getDate("time"));
				o.setUser_name(rs.getString("user_name"));
				o.setM_color(rs.getString("m_color"));
				v.add(o);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public void addReplyNote(int up_id, String title, String cont, Timestamp time, String user_name) {
		try {
			String sql="insert into note(up_id,title,cont,time,user_name) "
					+ "values(?,?,?,?,?)";
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, up_id);
			ps.setString(2,title);
			ps.setString(3, cont);
	
			
			ps.setTimestamp(4, time);
			ps.setString(5, user_name);
			ps.executeUpdate(); 
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void addModuleNote(int module_id, String title, String cont, Timestamp time, String user_name, String m_color) {
		try {
			String sql="insert into note(module_id,title,cont,time,user_name,m_color) "
					+ "values(?,?,?,?,?,?)";
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, module_id);
			ps.setString(2,title);
			ps.setString(3, cont);
			ps.setTimestamp(4, time);
			ps.setString(5, user_name);
			ps.setString(6, m_color);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void deleteFromId(int id) {
		String sql="delete from note where id =?";
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public List<NoteModel> AllOfTitle(String title) {
		String sql="select * from note where title=? ";
		List<NoteModel> arr=new ArrayList<NoteModel>();;
		NoteModel o;
		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				o=new NoteModel();
				o.setId(rs.getInt("id"));
				o.setModule_id(rs.getInt("module_id"));
				o.setUp_id(rs.getInt("up_id"));
				o.setTitle(rs.getString("title"));
				o.setCont(rs.getString("cont"));
				o.setTime(rs.getDate("time"));
				o.setUser_name(rs.getString("user_name"));
				o.setM_color(rs.getString("m_color"));
				arr.add(o);
			}
			ps.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

}
