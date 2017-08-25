package com.soda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet res;
	
	private final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://127.0.0.1:3306/soda";
	private final String USERNAME="root";
	private final String PASSWORD=null;
	public Connection getConn(){
		try {
			Class.forName(DRIVER_CLASS);
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn,PreparedStatement ps,ResultSet res){
		if(res!=null)
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
}
