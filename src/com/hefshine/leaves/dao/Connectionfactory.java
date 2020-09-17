package com.hefshine.leaves.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionfactory {
	public static final String url="jdbc:mysql://localhost:3306/leaves";
	public static final String username="root";
	public static final String password="root";
	Connection con;
	public Connectionfactory() 
	{
		con=null;
	}
	public boolean connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		if(con!=null)
			return true;
	
		return false;
	}
	public Connection getconnection()
	{
		return con;
	}
	public void closeConnection() throws SQLException {
		con.close();
	}
}
