package com.city.bbs.module.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.city.bbs.module.dao.IModuleDao;
import com.city.bbs.module.dao.impl.ModuleDaoImpl;

public class DaoFactory {
	public static Connection getConnection() throws Exception{
		Context context=new InitialContext();
		DataSource datasource=(DataSource)context.lookup("java:comp/env/"+"bbs");
		Connection connection=datasource.getConnection();
		context.close();
		return connection;
	}
	
	public static IModuleDao createModuleDao() throws Exception{
		return new  ModuleDaoImpl();
	}
}
