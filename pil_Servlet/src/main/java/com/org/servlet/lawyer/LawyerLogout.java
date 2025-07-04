package com.org.servlet.lawyer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lawyerLogout")
public class LawyerLogout extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession() ;
		hs.removeAttribute("doctObj");
		hs.setAttribute("succMsg", "logout success");
		resp.sendRedirect("index1.jsp");
	}
}
