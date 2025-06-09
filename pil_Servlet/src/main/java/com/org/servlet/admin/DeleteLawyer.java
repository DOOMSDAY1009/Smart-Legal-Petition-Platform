package com.org.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.LawyerDao;

@WebServlet("/deleteLawyer")
public class DeleteLawyer extends HttpServlet{
 
 	@Override
 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       	 
       	int id = Integer.parseInt(req.getParameter("id")) ;
       	
       	LawyerDao dao = new LawyerDao() ;
       	HttpSession hs = req.getSession() ;
       	
       	if(dao.deleteLawyer(id)) {
            	hs.setAttribute("succMsg", "Lawyer deleted Successfully");
            	resp.sendRedirect("admin/view_lawyer.jsp");
       	}else {
            	hs.setAttribute("errorMsg", "Something Went Wrong");
            	resp.sendRedirect("admin/view_lawyer.jsp");
       	}
 	}
 	
}
 
