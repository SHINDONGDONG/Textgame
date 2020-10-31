package textgame;

import java.io.IOException;
import java.util.Scanner;

public class Monster {
	Menu menu = new Menu();
	Skill s = new Skill();
	
	//몬스터이름
	String M_name;
	//몬스터 체력
	int M_HP;
	//몬스터 최대체력
	int M_HP_MAX;
	//몬스터 마력
	int M_MP;
	//몬스터 최대마력
	int M_MP_MAX;
	//몬스터 데미지
	int M_DMG;
	//몬스터 경험치
	int M_EXP;
	
	public Monster(String monster_name) {
		if("고블린".equals(monster_name)) {
			this.M_name = monster_name;
			this.M_HP = 20;
			this.M_HP_MAX = 20;
			this.M_DMG = 5;
			this.M_EXP = 100;
		}else if("하피".equals(monster_name)) {
			this.M_name = monster_name;
			this.M_HP = 100;
			this.M_HP_MAX = 100;
			this.M_DMG = 15;
			this.M_EXP = 200;
			
		}else if("오우거".equals(monster_name)) {
			this.M_name = monster_name;
			this.M_HP = 200;
			this.M_HP_MAX = 200;
			this.M_DMG = 30;
			this.M_EXP = 300;
			
		}else if("서큐버스".equals(monster_name)) {
			this.M_name = monster_name;
			this.M_HP = 400;
			this.M_HP_MAX = 400;
			this.M_DMG = 50;
			this.M_EXP = 400;
			
		}else if("마왕".equals(monster_name)) {
			this.M_name = monster_name;
			this.M_HP = 1000;
			this.M_HP_MAX = 1000;
			this.M_DMG = 100;
			this.M_EXP = 1000;
			
		}
	}
	
	//몬스터 hp보정(0이하가 되었을경우 0으로지정)
	public void setHp(Monster m) {
		if(m.M_HP < 0) {
			m.M_HP = 0;
		}
	}
	//몬스터의 반격
	public void isDied(CharInfo c, Monster m) {
		
		if(m.M_HP > 0 ) {
			c.HERO_HP -= M_DMG;
			System.out.println(m.M_name+" 이/가 반격을 가합니다.");
			System.out.println(m.M_DMG+"의 데미지를 받아습니다.");
			System.out.println("현재 캐릭터의 hp는 : " + c.HERO_HP+"/"+c.HERO_HP_MAX);
			System.out.println("************************");
		}else if(m.M_HP < 0 ) {
			System.out.println(m.M_name+" 가쓰러졌다.");
			System.out.println("************************");
		}
	}
	
	//몬스터 사냥 후 경험치 획득
	void setExp(Monster m,CharInfo c) {
		c.EXP += m.M_EXP;
		System.out.println("경험치 "+m.M_EXP + " 을 얻었습니다.");
		c.setLv(c);
	}
	
	//몬스터 전투
	void battle(CharInfo c,Monster m) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while(m.M_HP > 0) {
			//메뉴 클래스에 있는 액션메뉴 호출
			menu.actionMenu();
			//입력대기상태
			String input =sc.next();
			
			if("1".equals(input)) {
				m.M_HP = m.M_HP- c.DMG;
				System.out.println(m.M_name+"에게 "+c.DMG+"의 데미지를 주었습니다.");
				m.setHp(m);
				System.out.println("현재 고블린 체력 : " +m.M_HP +"/"+m.M_HP_MAX);
			}else if("2".equals(input)) {
				menu.skillMenu();
				//입력대기
				String skill =sc.next();
				if("1".equals(skill)) {
					//입력시 유저의 현재 마력 - 파이어볼 사용마력
					System.out.println("파이어볼을 시전합니다.");
					c.HERO_MP -= s.fireball_MP;
					m.M_HP -= s.fireball;
					//고블린의 현재 체력 - 파이어볼이 데ㅓ미지
					m.setHp(m);
					System.out.println(m.M_name+"의 체력은 "+m.M_HP+"/"+m.M_HP_MAX);
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
			m.isDied(c, m);
			//유저 캐릭터 보정
			c.modeCharInfo(c);
		}
		m.setExp(m, c);
		//보유중인 아이템
		System.out.println("보유중인 아이템은 : "+c.itemBag);
		System.out.println("마을로 돌아갑니다.");
	}	
	}
