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

@WebServlet("/lawyerUpdateProfile")
public class EditProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");

			int id = Integer.parseInt(req.getParameter("id"));

			Lawyer d = new Lawyer(id, fullName, dob, email, mobno, "");

			LawyerDao dao = new LawyerDao();
			HttpSession session = req.getSession();

			if (dao.editLawyerProfile(d)) {
				Lawyer updateLawyer = dao.getLawyersById(id);
				session.setAttribute("succMsgd", "Lawyer Update Sucessfully..");
				session.setAttribute("doctObj", updateLawyer);
				resp.sendRedirect("lawyer/edit_profile.jsp");
			} else {
				session.setAttribute("errorMsgd", "something wrong on server");
				resp.sendRedirect("lawyer/edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
