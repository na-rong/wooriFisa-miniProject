package service;

import model.domain.BookDTO;

public class ManageService {
	
	// 도서 등록하기
	public void insertBook(String book_name, String isbn, String author, String publisher) {
		BookDTO newBook = new BookDTO(book_name,isbn,author,publisher);

	}
	
	// 도서 수정하기
	
	// 도서 삭제하기	
	
}
