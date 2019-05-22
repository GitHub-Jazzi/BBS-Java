package com.city.bbs.counter.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.city.bbs.counter.dao.ICounterDao;
import com.city.bbs.counter.model.CounterModel;
import com.city.bbs.users.factory.DaoFactory;

public class CounterDaoImpl implements ICounterDao {

	@Override
	public CounterModel query() {
		String sql="select * from counter";
		CounterModel o=new CounterModel();
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
		
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				o.setEvening(rs.getInt("evening"));
				o.setMorning(rs.getInt("morning"));
				o.setNight(rs.getInt("night"));
				o.setNoon(rs.getInt("noon"));
			}
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public void updateMorning(int count) {
		String sql="update counter set morning=?";

		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void updateNoon(int count) {
		String sql="update counter set noon=?";

		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	public void updateEvening(int count) {
		// TODO Auto-generated method stub
		String sql="update counter set evening=?";

		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateNight(int count) {
		String sql="update counter set night=?";

		try {
			Connection con =DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
