package textgame;

import java.io.IOException;
import java.util.Scanner;

public class InputMenu {
	Menu menu = new Menu();
	Scanner sc = new Scanner(System.in);
	Save save = new Save();
	//method 명 : mainMenu
	//파라메터 : String Input
	//리턴 : x
	//기능 : 
	//1,2,3을 의외의 숫자를 입력했을 경우 
	
	public void mainMenu(String input) throws IOException {
		
		
		if("1".equals(input)) {
			System.out.println("새 게임입니다.");
			tutorial();
			town();
		}else if("2".equals(input)) {
			System.out.println("저장된 게임을 불러옵니다.");
			save.load();
			town();
		}else if("3".equals(input)) {
			System.out.println("게임을 종료합니다.");
			//자바 강제 종료처리
			System.exit(0);
		}else {
			System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
		}
		
	}
	public void tutorial() throws IOException {
		
		//캐릭터정보 불러오기 (싱글톤패턴)
		CharInfo c= CharInfo.loadCharInfo();
		Monster tutorial_m = new Monster("하피");
		Skill s = Skill.loadSkill();
		
		//반복문을 만들자 
		//고블린의 hp가 0 이될때까지 무한반복
		//메뉴클래스에 있는 action메뉴 호출
	
		while(tutorial_m.M_HP > 0) {
			//메뉴 클래스에 있는 액션메뉴 호출
			menu.actionMenu();
			//입력대기상태
			String input =sc.next();
			
			if("1".equals(input)) {
				tutorial_m.M_HP = tutorial_m.M_HP- c.DMG;
				System.out.println(tutorial_m.M_name+"에게 "+c.DMG+"의 데미지를 주었습니다.");
				tutorial_m.setHp(tutorial_m);
				System.out.println("현재 고블린 체력 : " +tutorial_m.M_HP +"/"+tutorial_m.M_HP_MAX);
			}else if("2".equals(input)) {
				menu.skillMenu();
				//입력대기
				String skill =sc.next();
				if("1".equals(skill)) {
					//입력시 유저의 현재 마력 - 파이어볼 사용마력
					System.out.println("파이어볼을 시전합니다.");
					c.HERO_MP -= s.fireball_MP;
					tutorial_m.M_HP -= s.fireball;
					//고블린의 현재 체력 - 파이어볼이 데ㅓ미지
					tutorial_m.setHp(tutorial_m);
					System.out.println(tutorial_m.M_name+"의 체력은 "+tutorial_m.M_HP+"/"+tutorial_m.M_HP_MAX);
				}else if("2".equals(skill)) {
					//힐을 시전합니다. 출력
					c.HERO_MP -= s.heal_MP;
					c.HERO_HP += s.heal;
					c.modeCharInfo(c);
					System.out.println("캐릭터 체력 : "+c.HERO_HP +"/"+c.HERO_HP_MAX);
				}else if("3".equals(skill)) {
					System.out.println("스킬사용을 취소합니다.");
					continue;
				}else {
					System.out.println("스킬을 사용하지 않아 몬스터가 반격을 가함");
				}
				//현재 스테이터스 표시
			}else if("3".equals(input)) {
				System.out.println("현재스테이터스입니다.");
				c.setStatus(c);
				continue;
				//1,2,3 외 다른것을 입력했을 경우
			}else {
				System.out.println("올바른 메뉴를 입력해주세요");
				continue;
			}
			//몬스터 반격
			tutorial_m.isDied(c, tutorial_m);
			//유저 캐릭터 보정
			c.modeCharInfo(c);
		}
		tutorial_m.setExp(tutorial_m, c);
		//보유중인 아이템
		System.out.println("보유중인 아이템은 : "+c.itemBag);
		System.out.println("마을로 돌아갑니다.");
	}	
	public void town() throws IOException {
		//휴식 객체화
		Rest r = new Rest();
		CharInfo c = CharInfo.loadCharInfo();
		Skill s =new Skill();
		Gamble g  = new Gamble();
		//저장 객체화
		Save save = new Save();
		
		while(true) {
			//마을메뉴 호출
			menu.townMenu();
			//입력대기
			String input = sc.next();
			if("1".equals(input)) {
				r.doRest(c);
			}else if("2".equals(input)) {
				System.out.println("던전으로 향합니다.");
				menu.monsterSelect();
				String monster = sc.next();
				if("1".equals(monster)) {
					System.out.println("고블린을 만났습니다.");
					Monster m = new Monster("고블린");
					m.battle(c, m);
				}else if("2".equals(monster)) {
					System.out.println("하피를 만났습니다.");
					Monster m = new Monster("하피");
					m.battle(c, m);
				}else if("3".equals(monster)) {
					System.out.println("오우거를 만났습니다.");
					Monster m = new Monster("오우거");
					m.battle(c, m);
				}else if("4".equals(monster)) {
					System.out.println("서큐버스을 만났습니다.");
					Monster m = new Monster("서큐버스");
					m.battle(c, m);
				}else if("5".equals(monster)) {
					System.out.println("마왕을 만났습니다.");
					Monster m = new Monster("마왕");
					m.battle(c, m);
				}else {
					System.out.println("잘못 입력햇어요~");
				}
				
			//상점 마법강화	
			}else if("3".equals(input)) {
				s.skillUp(c);
			}else if("4".equals(input)) {
				g.doGamble(c);
			//저장하기
			}else if("5".equals(input)) {
				System.out.println("게임을 저장합니다.");
				save.save(c);
			}else if("6".equals(input)) {
				System.out.println("게임종료합니다.");
				System.exit(0);
			}else {
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
	}
}

