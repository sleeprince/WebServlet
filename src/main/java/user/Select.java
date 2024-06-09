package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import utils.Util;
import DB.*;

public class Select extends HttpServlet {
	
	private final String page = "user/Select.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("number"));
		AppController db = new AppController();
		DBTable data = db.getData(num);
		request.setAttribute("user_data", data);
		Util.print(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("number"));
		AppController db = new AppController();
		DBTable data = db.getData(num);
		request.setAttribute("user_data", data);
		Util.print(request, response, page);
	}

}
