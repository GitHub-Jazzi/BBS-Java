package com.city.bbs.module.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.city.bbs.module.dao.IModuleDao;
import com.city.bbs.module.model.ModuleModel;
import com.city.bbs.users.factory.DaoFactory;

public class ModuleDaoImpl implements IModuleDao {

	/*返回所有模块*/
	@Override
	public List<ModuleModel> query() {
		String sql="select * from module";
		ModuleModel o;
		List<ModuleModel> v=new ArrayList<ModuleModel>();
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				o=new ModuleModel();
				o.setId(rs.getInt("id"));
				o.setModule_name(rs.getString("module_name"));
				o.setModule_cont(rs.getString("module_cont"));
				o.setUser_name(rs.getString("user_name"));
				o.setCs_pic(rs.getString("cs_pic"));
				o.setCs_color(rs.getString("cs_color"));
				v.add(o);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v ;
	}

	@Override
	public ModuleModel idOfModule(int id) {
		String sql="select * from module where id =?";
		ModuleModel o=new ModuleModel();
	
		try {
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			o.setId(rs.getInt("id"));
			o.setModule_name(rs.getString("module_name"));
			o.setModule_cont(rs.getString("module_cont"));
			o.setUser_name(rs.getString("user_name"));
			o.setCs_pic(rs.getString("cs_pic"));
			o.setCs_color(rs.getString("cs_color"));
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public void add(String module_name, String module_cont, String user_name, String cs_pic, String cs_color) {
		try {
			String sql="insert into module(module_name,module_cont,user_name,cs_pic,cs_color) values(?,?,?,?,?)";
			Connection con=DaoFactory.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, module_name);
			ps.setString(2, module_cont);
			ps.setString(3, user_name);
			ps.setString(4, cs_pic);
			ps.setString(5, cs_color);
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
