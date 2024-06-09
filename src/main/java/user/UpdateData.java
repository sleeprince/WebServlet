package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DB.*;

public class UpdateData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("number"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		int gen = Integer.parseInt(request.getParameter("gender"));
		
		AppController db = new AppController();
		DBTable data = db.getData(num);
		if("".equals(name)) name = data.getName();
		if("".equals(email)) email = data.getEmail();
		if("".equals(pwd)) pwd = data.getPwd();	
		
		db.updateData(num, name, email, pwd, gen);

		response.sendRedirect("Select?number=" + num);
	}

}
