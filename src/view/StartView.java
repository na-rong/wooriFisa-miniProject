package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ManageController;
import controller.UserController;
import model.domain.UserDTO;

public class StartView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserDTO nowUser = new UserDTO();		
		ArrayList<UserDTO> userArray = UserController.getAllUser();
		ManageController manageController = new ManageController();
		
		while (true) {
			System.out.println();
			System.out.println("------우리FISA 도서관------");

			System.out.println("id를 입력해주세요 : ");
			String login_id = sc.nextLine();
			
			for(int i = 0 ; i < userArray.size(); i++) {
				if(userArray.get(i).getId().equals(login_id)) {
					System.out.println("환영합니다 " + userArray.get(i).getUserName() +"님");
					nowUser = userArray.get(i);
								
					
					break;
				} else {					
					if(i == userArray.size() -1) {
						System.out.println("존재하지 않는 ID입니다.");
					}
				}
			}
			
			System.out.println("1. 모든 도서 보기");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 도서 반납하기");
			if(nowUser.getAuth() == 1) {
				System.out.println("4. 도서 등록하기");
				System.out.println("5. 도서 수정하기");
				System.out.println("6. 도서 삭제하기");
			}
			System.out.println("번호 입력 : ");
			int num = sc.nextInt();
			switch(num) {
			case 5:
				System.out.println("도서명 : ");
				String book_name = sc.nextLine();
				System.out.println("isbn : ");
				String isbn = sc.nextLine();
				System.out.println("작가 : ");
				String author = sc.nextLine();
				System.out.println("출판사 : ");
				String publisher = sc.nextLine();
				manageController.insertBook(book_name,isbn,author,publisher);
			case 6:
			case 7:
			}
		}
	}
}
