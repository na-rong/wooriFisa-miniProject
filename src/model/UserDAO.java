package model;

import java.util.ArrayList;

import model.domain.BookDTO;
import model.domain.UserDTO;
import service.UserService;

public class UserDAO {

	UserService userService = new UserService();

	static ArrayList<UserDTO> userArray = new ArrayList<>();

	static {
		userArray.add(new UserDTO("id1", "조성현", 1));
		userArray.add(new UserDTO("id2", "이주원", 1));
		userArray.add(new UserDTO("id3", "최나영", 0));
		userArray.add(new UserDTO("id4", "이현빈", 0));
	}

	public static ArrayList<UserDTO> getAllUser() {
		return userArray;
	}

	public void borrowBook(BookDTO book, UserDTO user) {
		UserService.borrowBook(book, user);
	}

	public void returnBook(BookDTO book, UserDTO user) {
		UserService.returnBook(book, user);
	}
}