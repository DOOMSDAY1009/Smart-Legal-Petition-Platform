package com.org.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.RecordDao;
import com.org.entity.Record;

@WebServlet("/appRecord")
public class RecordServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appoint_date = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String title = req.getParameter("title");
		int lawyer_id = Integer.parseInt(req.getParameter("doct"));
		String text = req.getParameter("text");

		Record ap = new Record(userId, fullname, gender, age, appoint_date, email, phno, title, lawyer_id,
				text, "Pending");

		RecordDao dao = new RecordDao();
		HttpSession session = req.getSession();

		if (dao.addRecord(ap)) {
			session.setAttribute("succMsg", "Record Sucessfully");
			resp.sendRedirect("user_record.jsp");
		} else {
			session.setAttribute("errorMsg", "Something wrong on server");
			resp.sendRedirect("user_record.jsp");
		}

	}

}
