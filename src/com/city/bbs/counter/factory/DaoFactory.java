package com.city.bbs.counter.factory;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.city.bbs.counter.dao.ICounterDao;
import com.city.bbs.counter.dao.impl.CounterDaoImpl;

public class DaoFactory {
	
	public static Connection getConnection() throws Exception{
		Context context=new InitialContext();
		DataSource datasource=(DataSource)context.lookup("java:comp/env/"+"bbs");
		Connection connection=datasource.getConnection();
		context.close();
		return connection;
	}
	public static ICounterDao createCounterDao() throws Exception{
		return new  CounterDaoImpl();
	}
}
