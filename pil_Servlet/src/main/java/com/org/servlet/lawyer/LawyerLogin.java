package com.org.servlet.lawyer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.LawyerDao;
import com.org.entity.Lawyer;

@WebServlet("/lawyerLogin")
public class LawyerLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email") ;
		String password = req.getParameter("password");
		
		HttpSession hs = req.getSession() ;
		
		LawyerDao dao = new LawyerDao() ;
		Lawyer d = dao.login(email, password);
		
		if(d!=null) {
			hs.setAttribute("doctObj", d);
			resp.sendRedirect("lawyer/index.jsp");
		}else {
			hs.setAttribute("errorMsg", "invalid email or password");
			resp.sendRedirect("lawyer_login.jsp");
		}
	}
}
