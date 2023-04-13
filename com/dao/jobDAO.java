package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.job;

public class jobDAO {
   private Connection conn;

public jobDAO(Connection conn) {
	super();
	this.conn = conn;
}
    
     
  public boolean addJob(job j) {
	  boolean f=false;
	  try {
		String sql="insert into jobs(title,description,catergory,location) values(?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, j.getTitle());
		ps.setString(2, j.getDescription());
		ps.setString(3, j.getCatergory());
		ps.setString(4, j.getLocation());
		int i=ps.executeUpdate();
		if(i==1) f=true;
	} catch (Exception e) {
		System.out.println(e);
	}
	  return f;
  }
  
    public List<job> getJob(){
    	List<job>list=new ArrayList<job>();
    	job j=null;
    	try {
			String sql="select * from jobs order by id desc";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				j=new job();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCatergory(rs.getString(4));
				j.setLocation(rs.getString(5));
				j.setPdate(rs.getString(6)+"");
				list.add(j);
			}
    		
    		
		} catch (Exception e) {
			System.out.println(e);
		}
    	
    	return list;
    }
    
    public job getJobBYId(int id){
    	//List<job>list=new ArrayList<job>();
    	job j=null;
    	try {
			String sql="select * from jobs where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				j=new job();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCatergory(rs.getString(4));
				j.setLocation(rs.getString(5));
				j.setPdate(rs.getString(6)+"");
				//list.add(j);
			}
    		
    		
		} catch (Exception e) {
			System.out.println(e);
		}
    	
    	return j;
    }
    
    public boolean updateJob(job j) {
    	boolean f=false;
  	  try {
  		String sql="update jobs set title=?,description=?,catergory=?,location=? where id=?";
  		PreparedStatement ps=conn.prepareStatement(sql);
  		ps.setString(1, j.getTitle());
  		ps.setString(2, j.getDescription());
  		ps.setString(3, j.getCatergory());
  		ps.setString(4, j.getLocation());
  		ps.setInt(5,j.getId());
  		int i=ps.executeUpdate();
  		if(i==1) f=true;
  	} catch (Exception e) {
  		System.out.println(e);
  	}
  	  return f;
    }
    public boolean deleteJob(int id) {
    	boolean f=false;
    	try {
			String sql="delete from jobs where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1)
			 f=true;
    		
    		
		} catch (Exception e) {
			System.out.println(e);
		}
    	return f;
    }
  
}
