package textgame;

import java.io.IOException;
import java.util.Scanner;

public class GameStart {

	public static void main(String[] args) throws IOException {
		//메뉴 스타트 객체화
		Menu menu = new Menu();
		InputMenu inputMenu = new InputMenu();
		
		
		//게임종료 변수선언 플래그
		boolean exit_flag = false;
		
		//게임종료 exit_flag의 값이 true가 될때까지 무한반복
		while(exit_flag == false) {

			Scanner sc = new Scanner(System.in);
			menu.startMenu();
			String input = sc.next();
			inputMenu.mainMenu(input);
			inputMenu.tutorial();
			
		}
		
	}

}
