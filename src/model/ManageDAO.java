package model;

import service.ManageService;

public class ManageDAO {
	ManageService manageService = new ManageService();
	
	public void insertBook(String book_name, String isbn, String author, String publisher) {
		manageService.insertBook(book_name, isbn, author, publisher);
	}
}
