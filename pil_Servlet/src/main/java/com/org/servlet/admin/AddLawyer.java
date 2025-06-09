package com.org.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.LawyerDao;
import com.org.entity.Lawyer;
 
@WebServlet("/addLawyer")
public class AddLawyer extends HttpServlet {
 
 	@Override
 	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       	
       	try {
            	String fullName = req.getParameter("fullname") ;
            	String dob = req.getParameter("dob") ;
            	String email = req.getParameter("email") ;
            	String mobno = req.getParameter("mobno") ;
            	String password = req.getParameter("password") ;
            	
            	Lawyer d = new Lawyer(fullName, dob, email, mobno, password) ;
            	
            	LawyerDao dao = new LawyerDao() ;
            	
            	HttpSession hs = req.getSession() ;
            	
            	if(dao.registerLawyer(d)) {
                  	hs.setAttribute("succMsg", "Lawyer Added Successfully");
                  	resp.sendRedirect("admin/lawyer.jsp");
            	}else {
                  	hs.setAttribute("errorMsg", "Something Went Wrong");
                  	resp.sendRedirect("admin/lawyer.jsp");
            	}
            	
       	}catch (Exception e) {
            	e.printStackTrace();
       	}
 	}
}
