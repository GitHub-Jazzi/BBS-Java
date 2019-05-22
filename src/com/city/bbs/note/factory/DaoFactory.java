package com.city.bbs.note.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.city.bbs.note.dao.INoteDao;
import com.city.bbs.note.dao.impl.NoteDaoImpl;

public class DaoFactory {
	public static Connection getConnection() throws Exception{
		Context context=new InitialContext();
		DataSource datasource=(DataSource)context.lookup("java:comp/env/"+"bbs");
		Connection connection=datasource.getConnection();
		context.close();
		return connection;
	}
	
	public static INoteDao createNoteDao() throws Exception{
		return new  NoteDaoImpl();
	}
}
