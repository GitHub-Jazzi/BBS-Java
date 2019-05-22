package com.city.bbs.users.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.city.bbs.note.dao.INoteDao;
import com.city.bbs.note.dao.impl.NoteDaoImpl;
import com.city.bbs.users.dao.IUsersDao;
import com.city.bbs.users.dao.impl.UsersDaoImpl;

public class DaoFactory {
	public static Connection getConnection() throws Exception{
		Context ctx=new InitialContext();
		DataSource ds=(DataSource)ctx.lookup("java:comp/env/"+"bbs");
		Connection con=ds.getConnection();
		ctx.close();
		return con;
	}
	public static IUsersDao createUsersDao() throws Exception{
		return new  UsersDaoImpl();
	}
	
}
