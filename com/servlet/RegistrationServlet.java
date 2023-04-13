package com.servlet; 

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBconnect;
import com.dao.userDAO;
import com.entity.user;
@WebServlet("/signup")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name=req.getParameter("name");
			String qua=req.getParameter("qua");
			String em=req.getParameter("em");
			String ps=req.getParameter("ps");
			
			userDAO dao=new userDAO(DBconnect.getConn());
			user u=new user(name,em,ps,qua,"user");
			
			boolean f=dao.addUser(u);
			HttpSession session=req.getSession();
			if(f) {
				session.setAttribute("msg", "registration successfull");
				resp.sendRedirect("signup.jsp");
			}
			else {
				session.setAttribute("msg", "unsuccessful");
				resp.sendRedirect("signup.jsp");
			}
			
			
			
		} catch (Exception e) {
		System.out.println(e);
		}
		
		
		
		
		
	}

	
	
}
