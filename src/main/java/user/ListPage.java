package user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import DB.*;
import utils.Util;

public class ListPage extends HttpServlet {
	
	private final String page = "user/ListPage.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppController db = new AppController();
		List<DBTable> list = db.getData();
		request.setAttribute("data_list", list);		
		Util.print(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Util.print(request, response, page);
	}

}
