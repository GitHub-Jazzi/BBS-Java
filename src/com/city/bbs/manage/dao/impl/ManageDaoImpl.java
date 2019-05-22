package com.city.bbs.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.city.bbs.manage.dao.IManageDao;
import com.city.bbs.users.factory.DaoFactory;

public class ManageDaoImpl implements IManageDao {

	@Override
	public String query(String mail) {
		String sql="select * from manage where mail =?";
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

}
