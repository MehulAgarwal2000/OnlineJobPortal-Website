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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			jobDAO dao=new jobDAO(DBconnect.getConn());
			boolean f=dao.deleteJob(id);
			HttpSession session=req.getSession();
			if(f) {
				  session.setAttribute("msg", "job deleted successfully");
				  resp.sendRedirect("view.jsp");
			  }
			  else {
				  session.setAttribute("msg", "error");
				  resp.sendRedirect("view.jsp");
			  }
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
