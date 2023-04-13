package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBconnect;
import com.dao.jobDAO;
import com.entity.job;

@WebServlet("/addjob")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    
		 try {
			 String title=req.getParameter("title");
			  String locationString=req.getParameter("location");
			  String catergory=req.getParameter("catergory");
			  String desc=req.getParameter("desc");
			  
			  job j=new job();
			  j.setTitle(title);
			  j.setDescription(desc);
			  j.setLocation(locationString);
			  j.setCatergory(catergory);
			  
			  HttpSession session=req.getSession();
			  jobDAO dao=new jobDAO(DBconnect.getConn());
			  boolean f=dao.addJob(j);
			  
			  if(f) {
				  session.setAttribute("msg", "job posted successfully");
				  resp.sendRedirect("addjob.jsp");
			  }
			  else {
				  session.setAttribute("msg", "error");
				  resp.sendRedirect("addjob.jsp");
			  }
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
