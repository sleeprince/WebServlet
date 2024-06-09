package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import DB.*;

public class InsertData extends HttpServlet {	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		int gen = Integer.parseInt(request.getParameter("gender"));
		
		AppController db = new AppController();
		db.insertData(name, email, pwd, gen);
		
		List<DBTable> list = db.getData();
		request.setAttribute("data_list", list);
		response.sendRedirect("ListPage");
	}

}
