package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Users;

public class UsersDAO {

	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
	
	public List<Users> listOfUsers(){
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Users> users = session.createQuery("from YOUR_DB_TABLE_NAME").getResultList();
		
		return users;
	}

	public void addUser(Users newUser) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(newUser);
		session.getTransaction().commit();
		
	}

	public void updateUser(int userID, String firstName, String lastName, String email, String phoneNumber) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Users user = session.get(Users.class, userID);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPhoneNumber(phoneNumber);
		session.getTransaction().commit();
	}

	public void deleteUserOperation(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Users user = session.get(Users.class, id);
		session.delete(user);
		session.getTransaction().commit();
	}
}
