package utils;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Util {
	
	public static void print(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		String root = "/WEB-INF/views/";
		RequestDispatcher view = request.getRequestDispatcher(root.concat(page));
		view.forward(request, response); 
	}
}
