package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsersDAO;
import entity.Users;

public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
		case "addUser":
			showAddUserForm(request, response);
			break;
		case "updateUserForm":
			showUpadateUserForm(request, response);
			break;
		case "deleteUser":
			deleteUser(request, response);
			break;
		default:
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		
		switch (operation) {
		case "addUserOperation":
			Users newUser = new Users(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"), request.getParameter("phoneNumber")); 
			addUserOperation(newUser);
			showUsersTable(request, response);
			break;
		case "updateUserOperation":
			updateUserOperation(request, response);
			break;
		default:
			break;
		}
		
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("userID"));
		new UsersDAO().deleteUserOperation(id);
		showUsersTable(request, response);
	}

	private void updateUserOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		
		new UsersDAO().updateUser(userID, firstName, lastName, email, phoneNumber);
		showUsersTable(request, response);
	}

	private void showUpadateUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("updateUserForm.jsp").forward(request, response);
	}
	
	private void addUserOperation(Users newUser) {
		new UsersDAO().addUser(newUser);
	}


	private void showAddUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addUserForm.jsp").forward(request, response);
	}
	
	private void showUsersTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Users> users = new UsersDAO().listOfUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("usersTable.jsp").forward(request, response);
	}
	
}
