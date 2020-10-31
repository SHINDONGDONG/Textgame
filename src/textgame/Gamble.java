package textgame;

import java.util.Scanner;

public class Gamble {
	Scanner sc = new Scanner(System.in);
	Util u = new Util();
	public void doGamble(CharInfo c) {
		//나가기 변수지정
		boolean isExit = true;
		
		while(isExit) {
			System.out.println("도박입니다.");
			System.out.println("동전게임(보상 2배/확률 50%)");
			System.out.println("걸고싶은 동전의 면을 선택해주세요 (앞/뒤)");
			String input = sc.next();
			if(!"앞".equals(input) &&!"뒤".equals(input)) {
				System.out.println("잘못된 입력입니다.");
				continue;
			}
			
			System.out.println("얼마를 거시겠습니까? 현재 소지중인 골드 : " + c.GOLD);
			//입력대기 골드
			int gold = sc.nextInt();
			
			if(gold > c.GOLD || c.GOLD <= 0) {
				System.out.println("소지골드가 부족합니다.");
			}else {
				boolean result =u.dice02();
				if(result == true) {
					System.out.println(input+" 면이 나왔습니다.");
					System.out.println(gold*2+" 를 획득했습니다.");
					c.GOLD += gold * 2;
				}else {
					if(input.equals("앞")) {
						System.out.println("뒷면이 나왔습니다.");
					}else {
						System.out.println("앞면이 나왔습니다.");
					}
					c.GOLD -= gold;
				}
			}
			System.out.println("현재 소지중인 골드 : " + c.GOLD);
			System.out.println("계속하시려면  '계속하기' 를 클릭 ");
			System.out.println("종료하시려면  '종료하기' 를 클릭 ");
			
			input = sc.next();
			if("계속하기".equals(input)) {
				isExit = true;
			}else if("종료하기".equals(input)){
				System.out.println("마을로 복귀합니다.");
				isExit = false;
			}
		}
		
	}
}
