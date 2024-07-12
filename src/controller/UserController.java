package controller;

import java.util.ArrayList;

import model.ManageDAO;
import model.UserDAO;
import model.domain.BookDTO;
import model.domain.UserDTO;

public class UserController {
	UserDAO userDAO = new UserDAO();

	// common
	public ArrayList<UserDTO> getAllUser() {
		return userDAO.getAllUser();
	}

	public void borrowBook(BookDTO book, UserDTO user) {
		userDAO.borrowBook(book, user);
	}

	public void returnBook(BookDTO book, UserDTO user) {
		userDAO.returnBook(book, user);
	}

}
