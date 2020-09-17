package com.hefshine.leaves.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hefshine.leaves.beans.Leaves;


public class Leavesdao {
	
	public boolean insertleaves(Leaves leaves) throws ClassNotFoundException, SQLException
	{
		Connectionfactory connection=new Connectionfactory();
		connection.connect();
		Connection con=connection.getconnection();
		String sql="insert into leaves  (lid,uid,ltype,applied_date,fromdate,todate,status,discription,reason) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement statement=con.prepareStatement(sql);


		statement.setInt(1, leaves.getLid());
		statement.setInt(2, leaves.getUid());
		statement.setString(3, leaves.getLtype());
		statement.setString(4, leaves.getApplied_date());
		statement.setString(5, leaves.getFormdate());
		statement.setString(6, leaves.getTodate());
		statement.setString(7, leaves.getStatus());
		statement.setString(8 ,leaves.getDiscriptions());
		statement.setString(9, leaves.getReason());

		statement.executeUpdate();
		con.close();

		return false;

	}

	public ArrayList<Leaves> selectAll() throws ClassNotFoundException, SQLException
	{
		Connectionfactory connection=new Connectionfactory();
		connection.connect();
		Connection con=connection.getconnection();

		String sql="select * from leaves where status='applied'";

		PreparedStatement statement=con.prepareStatement(sql);

		ResultSet rs= statement.executeQuery();

		ArrayList<Leaves> list=new ArrayList<>();

		while(rs.next())
		{

			Leaves leaves=new Leaves();

			leaves.setLid(rs.getInt("lid")); 
			leaves.setUid(rs.getInt("uid"));
			leaves.setLtype(rs.getString("ltype"));
			leaves.setApplied_date(rs.getString("applied_date"));
			leaves.setFormdate(rs.getString("fromdate"));
			leaves.setTodate(rs.getString("todate"));
			leaves.setStatus(rs.getString("status"));
			leaves.setDiscriptions(rs.getString("discription"));
			leaves.setReason(rs.getString("reason"));
			list.add(leaves);
		}

		con.close();

		return list;

	}

	public void updateAll(HashMap<String, String>  actionmap) throws ClassNotFoundException, SQLException
	{
		Connectionfactory connection=new Connectionfactory();
		connection.connect();
		Connection con=connection.getconnection();


		for(Map.Entry<String, String> entry:actionmap.entrySet())
		{

			int key=Integer.parseInt(entry.getKey());
			String value=entry.getValue();

			String sql="update leaves set status=? where lid=?";
			PreparedStatement statement=con.prepareStatement(sql);
			try
			{
				statement=con.prepareStatement(sql);
				statement.setString(1, value);
				statement.setInt(2, key);
				statement.executeUpdate();

			}catch( SQLException e)
			{
				e.printStackTrace();
			}
			/*con.close();*/
			connection.closeConnection();
		}
	}

	public ArrayList<Leaves> leavestatus(int uid) throws SQLException, ClassNotFoundException 
	{

		Connectionfactory connection=new Connectionfactory();
		connection.connect();
		Connection con=connection.getconnection();


		String sql="select * from leaves where uid=?";

		PreparedStatement statement=con.prepareStatement(sql);
		statement.setInt(1, uid);
		ResultSet rs=statement.executeQuery();

		
		ArrayList<Leaves> list = new ArrayList<Leaves>();

		while(rs.next())
		{ 
			Leaves leaves=new Leaves();
			
			leaves.setLtype(rs.getString("ltype"));
			leaves.setApplied_date(rs.getString("applied_date"));
			leaves.setFormdate(rs.getString("fromdate"));
			leaves.setTodate(rs.getString("todate"));
			leaves.setStatus(rs.getString("status"));
			leaves.setDiscriptions(rs.getString("discription"));
			leaves.setReason(rs.getString("reason"));
			list.add(leaves);

		}

		connection.closeConnection();
		con.close();

		return list ;

	}


}
