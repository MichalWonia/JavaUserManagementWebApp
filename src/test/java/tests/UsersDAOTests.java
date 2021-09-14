package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import DAO.UsersDAO;
import entity.Users;

public class UsersDAOTests {

	private UsersDAO usersDAO;

	@BeforeEach
	void init() {
		usersDAO = new UsersDAO();
	}
	
	@Test
	@Disabled // remove this to run the test
	public void getListOfAllUsersTest() {
		Iterable<Users> usersList = usersDAO.listOfUsers();
		Assert.assertNotNull(usersList);
		usersList.forEach(System.out::println);
	}
	
	@Test
	@Disabled
	public void addNewUserTest() {
		Users newUser = new Users("TestFirstName", "TestLastName", "TestEmail", "TestPhoneNumber");
		usersDAO.addUser(newUser);
		List<Users> listOfUsers = usersDAO.listOfUsers();
		Assert.assertNotNull(listOfUsers.contains(newUser));
	}
	
	@Test
	@Disabled
	public void updateUserTest() {
		
		// set user ID which you want to update 
		int updatedUserId = 10;
		String newFirstName = "newFirstName";
		String newLastName = "newLastName";
		String newEmail = "newEmail";
		String newPhoneNumber = "newPhoneNumber";
		
		Users updatedUser = new Users(newFirstName, newLastName, newEmail, newPhoneNumber);
		
		usersDAO.updateUser(updatedUserId, updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getEmail(), updatedUser.getPhoneNumber());
		List<Users> listOfUsers = usersDAO.listOfUsers();
		Assert.assertNotNull(listOfUsers.contains(updatedUser));
	}
	
	@Test
	@Disabled
	public void deleteUserTest() {
		
		// set user ID which you want to delete
		int deleteUserId = 10;
		usersDAO.deleteUserOperation(deleteUserId);
		List<Users> listOfUsers = usersDAO.listOfUsers();
		boolean isDeletedUserPresent = listOfUsers.stream().anyMatch(user -> user.getId() == deleteUserId);
		Assert.assertEquals(isDeletedUserPresent, false);
	}
}
