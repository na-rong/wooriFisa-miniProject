package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ManageController;
import controller.UserController;
import model.domain.BookDTO;
import model.domain.UserDTO;

public class StartView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserDTO nowUser = new UserDTO();
		int checkLogin = -1;
		ArrayList<UserDTO> userArray = UserController.getAllUser();
		ManageController manageController = new ManageController();

		while (true) {
			if (checkLogin == -1) {
				System.out.println();
				System.out.println("------우리FISA 도서관------");

				System.out.println("id를 입력해주세요 : ");
				String login_id = sc.next();

				for (int i = 0; i < userArray.size(); i++) {
					if (userArray.get(i).getId().equals(login_id)) {
						System.out.println("환영합니다 " + userArray.get(i).getUserName() + "님");
						nowUser = userArray.get(i);
						checkLogin = 1;
						break;
					} else {
						if (i == userArray.size() - 1) {
							System.out.println("존재하지 않는 ID입니다.");
						}
					}
				}
			} else {
				System.out.println("1. 모든 도서 보기");
				System.out.println("2. 도서 대여하기");
				System.out.println("3. 도서 반납하기");
				if (nowUser.getAuth() == 1) {
					System.out.println("4. 도서 등록하기");
					System.out.println("5. 도서 수정하기");
					System.out.println("6. 도서 삭제하기");
				}
				System.out.println("번호 입력 : ");
				int num = sc.nextInt();
				switch (num) {
				case 4:
					System.out.println("도서명 : ");
					String book_name = sc.next();
					System.out.println("isbn : ");
					String isbn = sc.next();
					System.out.println("작가 : ");
					String author = sc.next();
					System.out.println("출판사 : ");
					String publisher = sc.next();
					manageController.insertBook(book_name, isbn, author, publisher);
					break;
				case 5:
					System.out.println("수정하려는 도서의 isbn을 입력하세요 : ");
					String isbn_update = sc.next();
					int bookArray_idx = manageController.checkIsbn(isbn_update);
					if(bookArray_idx == -9999) {
						System.out.println("존재하지 않는 isbn입니다.");
						System.out.println();
					} else {
						System.out.println("도서명 : ");
						String book_name_upd = sc.next();
						System.out.println("작가 : ");
						String author_upd = sc.next();
						System.out.println("출판사 : ");
						String publisher_upd = sc.next();
						manageController.updateBook(bookArray_idx,book_name_upd,author_upd,publisher_upd);
					}
					break;
				case 6:
					break;
				}
			}
		}
	}
}
