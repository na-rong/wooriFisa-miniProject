package service;

import java.util.ArrayList;

import model.BookDAO;
import model.domain.BookDTO;
import model.domain.UserDTO;

public class UserService {

	public static UserDTO borrowBook(BookDTO book, UserDTO user) {
		ArrayList<BookDTO> bookList = BookDAO.getAllBook();

		// 해당 도서를 보유하고 있는지 확인
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookName().equals(book.getBookName())) {
				System.out.println(book.getBookName() + "을 대여하겠습니다.");
				bookList.remove(i);
				break;
			} else {
				if (i == bookList.size() - 1)
					System.out.println(book.getBookName() + "을 대여할 수 없습니다");
			}
		}
		// 회원의 대여 도서 목록에 추가
		user.getBookArray().add(book);

		return user;
	}

	public static void returnBook(BookDTO book, UserDTO user) {
		// 반납하려는 도서를 대여한 기록이 있는지 확인
		ArrayList<BookDTO> ownBook = user.getBookArray();

		for (int i = 0; i < ownBook.size(); i++) {
			if (ownBook.get(i).getBookName().equals(book.getBookName())) {
				System.out.println(book.getBookName() + "을 반납하겠습니다.");
				ownBook.remove(i);
				break;
			} else {
				if (i == ownBook.size() - 1)
					System.out.println(book.getBookName() + "을 대여한 기록이 없습니다.");
			}
		}

		// 반납된 도서를 다시 전체 도서 목록에 추가
		ArrayList<BookDTO> bookList = BookDAO.getAllBook();
		bookList.add(book);
	}
}