package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.UserDAO;
import model.domain.UserDTO;

public class StartView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		UserDTO nowUser = new UserDTO();		
		ArrayList<UserDTO> userArray = UserDAO.getAllUser();

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
		}
	}
}
