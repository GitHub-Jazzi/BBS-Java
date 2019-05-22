package com.city.bbs.users.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.bbs.users.dao.IUsersDao;
import com.city.bbs.users.factory.DaoFactory;
import com.city.bbs.users.model.UsersModel;

public class UsersDaoImpl implements IUsersDao {

	@Override
	public void add(String mail, String passworld, byte[] pic)  {
	
		try {
			String sql="insert into users(mail,password,pic) values(?,?,?)";
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2,passworld);
			ps.setBytes(3, pic);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modify(String mail, String newPassworld) {
		String sql="update  users set password=? where mail=?";
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(2, mail);
			ps.setString(1, newPassworld);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String mail) {
		String sql="delete from users where mail =?";
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String query(String mail) {
		String sql="select * from users where mail =?";
		String ans=null;
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mail);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				ans=rs.getString("password");
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int numOfUser() {
		String sql="select count(*) from users";
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
	public UsersModel mailToUser(String mail) {
		String sql="select * from users where mail=?";
		UsersModel o=new UsersModel();
		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mail);
			ResultSet rs=ps.executeQuery();
			rs.next();
			o.setMail(rs.getString("mail"));
			o.setPassword(rs.getString("password"));
			o.setPic(rs.getBytes("pic"));
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	@SuppressWarnings("null")
	@Override
	public List<UsersModel> AllOfUser() {
		String sql="select * from users ";
		List<UsersModel> arr=new ArrayList<UsersModel>();;
		UsersModel o;
		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				o=new UsersModel();
				o.setMail(rs.getString("mail"));
				o.setPassword(rs.getString("password"));
				o.setPic(rs.getBytes("pic"));
				arr.add(o);
			}
			ps.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public UsersModel objFromMail(String mail) {
		String sql="select * from users where mail=?";
		UsersModel o=new UsersModel();
		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mail);
			ResultSet rs=ps.executeQuery();
			rs.next();
			o.setMail(rs.getString("mail"));
			o.setPassword(rs.getString("password"));
			o.setPic(rs.getBytes("pic"));
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public void update(String mail, String mm) {
		String sql="update users set password=? where mail= ?";

		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, mm);
			ps.setString(2, mail);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}

