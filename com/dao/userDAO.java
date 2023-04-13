package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.user;

public class userDAO {
     private Connection conn;

	public userDAO(Connection conn) {
		super();
		this.conn = conn;
	}
     
     public boolean addUser(user u) {
    	 boolean f=false;
    	 
    	 try {
			String sql="insert into user(name,qualification,email,password,role) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getQualification());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, "user");
			
			int i=ps.executeUpdate();
			if(i==1)
				f=true;
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
    	 
    	 return f;
     }
     public user login(String em,String psw) {
    	 user u=null;
    	 try {
			String sql="select * from user where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, em);
			//ps.setString(2, ps);
			ps.setString(2, psw);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new user();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setQualification(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setRole(rs.getString(6));
				
			}
    		 
    		 
		} catch (Exception e) {
			System.out.println(e);
		}
    	 return u;
     }
     
}
