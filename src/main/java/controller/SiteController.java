package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsersDAO;
import entity.Users;

public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
		case "usersTable":
			showUsersList(request, response);
			break;

		default:
			break;
		}
	}

	private void showUsersList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Users> users = new UsersDAO().listOfUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("usersTable.jsp").forward(request, response);
	}

}
