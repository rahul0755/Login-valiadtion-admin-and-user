
package com.hefshine.leaves.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.ws.Response;

import com.hefshine.leaves.beans.Leaves;
import com.hefshine.leaves.beans.User;


public class Userdao {

	public boolean insert(User u) throws ClassNotFoundException, SQLException
	{

		Connectionfactory connection=new Connectionfactory();
		connection.connect();
		Connection con=connection.getconnection();
		String sql="insert into user(username,password,role,status) values(?,?,?,?)";

		PreparedStatement statement=con.prepareStatement(sql);

		statement.setString(1, u.getUname());
		statement.setString(2, u.getPassword());
		statement.setString(3, u.getRole());
		statement.setString(4, u.getStatus());

		statement.executeUpdate();

		con.close();
		return false;

	}
	public User check(String usernamet,String passwordt) throws ClassNotFoundException, SQLException
	{

		Connectionfactory connection=new Connectionfactory();
		connection.connect();
		Connection con=connection.getconnection();

		User user= null ;
		ResultSet rs =null;
		String sql="select * from user where username=? and password=?";

		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1, usernamet);
		statement.setString(2, passwordt);



		rs = statement.executeQuery();

		if( rs != null)
		{
			try {
				rs.next();

				int id=rs.getInt("uid");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String role=rs.getString("role");
				String status= rs.getString("status");

				user = new User();

				user.setId(id);
				user.setUname(username);
				user.setPassword(password);
				user.setRole(role);
				user.setStatus(status);

				if(user.getUname().equals(username)&& user.getPassword().equals(password)&& user.getStatus().equals(status))
				{
					connection.closeConnection();
					/*con.close();*/
					
				}
			}catch(SQLException e)
			{	
				e.printStackTrace();
			}
		}
		return user ;
	}


}



