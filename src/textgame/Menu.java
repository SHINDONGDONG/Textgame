package textgame;

public class Menu {


	public void startMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 게임시작");
		System.out.println("2. 불러오기");
		System.out.println("3. 게임종료");
	}
	
	//메소드 명 : actionMenu
	
	public void actionMenu() {
		System.out.println("행동을 선택하세요.");
		System.out.println("1. 공격");
		System.out.println("2. 스킬");
		System.out.println("3. 현재 스테이터스");
	}
	
	public void skillMenu() {
		System.out.println("사용할 스킬을 선택하세요.");
		System.out.println("1. 파이어볼");
		System.out.println("2. 힐");
		System.out.println("3. 취소");
	}

	public void townMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1. 여관(휴식)");
		System.out.println("2. 던전으로(전투)");
		System.out.println("3. 상점(마법강화)");
		System.out.println("4. 도박");
		System.out.println("5. 저장하기");
		System.out.println("6. 게임종료");
	}
	public void monsterSelect() {
		System.out.println("몬스터를를 선택하세요.");
		System.out.println("1. 고블린");
		System.out.println("2. 하피");
		System.out.println("3. 오우거");
		System.out.println("4. 서큐버스");
		System.out.println("5. 마왕");
	}
}
