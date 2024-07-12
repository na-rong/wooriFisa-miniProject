package controller;

import model.ManageDAO;

public class ManageController {
	ManageDAO manageDAO = new ManageDAO();
	
	public void insertBook(String book_name, String isbn, String author, String publisher) {
		manageDAO.insertBook(book_name, isbn, author, publisher);
	}
}
