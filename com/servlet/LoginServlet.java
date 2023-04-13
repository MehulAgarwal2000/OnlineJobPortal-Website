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
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String em=req.getParameter("email");
			String ps=req.getParameter("password");
			HttpSession session=req.getSession();
			user u=new user();
			if("admin@gmail.com".equals(em)&&"admin@123".equals(ps)) {
				session.setAttribute("userobj", u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
			}
			else {
				
				userDAO dao=new userDAO(DBconnect.getConn());
				user user=dao.login(em, ps);
				if(user!=null) {
					session.setAttribute("userobj", user);
					resp.sendRedirect("home.jsp");
				}
				else {
					session.setAttribute("msg", "invalid");
					resp.sendRedirect("login.jsp");
				}
				
				
			}
			
			
		} catch (Exception e) {
		    System.out.println(e);
		}
	}

	
	
}
