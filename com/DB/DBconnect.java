package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
     private static Connection conn;
     
     public static Connection getConn() {
    	 try {
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/job_portal2","root","Mehul@0308");
			}
    		 
    		 
		} catch (Exception e) {
			System.out.println(e);
		}
    	 return conn;
     }
}
