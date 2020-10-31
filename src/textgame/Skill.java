package textgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Skill {

	private static Skill skillInfo = new Skill();
	
	int fireball;
	int fireball_MP;
	int heal;
	int heal_MP;
	
	List<String> skills = new ArrayList<>();  
	
	public Skill(){
		skills.add("파이어볼");
		skills.add("힐");
		this.fireball = 100;
		this.fireball_MP = 30;
		this.heal = 100;
		this.heal_MP = 30;
	}
	
	
	
	public static Skill loadSkill() {
		return skillInfo;
	}
	
	//스킬강하ㅗ
	void skillUp(CharInfo c) {
		Scanner sc = new Scanner(System.in);
		Util u = new Util();
		if(c.itemBag != null && c.itemBag.contains("마법강화제")) {
		
		System.out.println("마법을 강화합니다(성공확률 50%)");
		System.out.println("강화 하시겠습니까?");
		System.out.println("1.네");
		System.out.println("2.아니오");
		String input = sc.next();
		
		if("1".equals(input)) {
			int upgrade = u.dice01();
			if(upgrade == 0) {
				System.out.println("강화에 성공하였습니다.");
				System.out.println("파이어볼의 공격력이 증가 하였습니다.");
				System.out.println("힐의 회복량이 증가 하였습니다.");
				skillInfo.fireball += 100;
				skillInfo.fireball_MP += 10;
				skillInfo.heal += 50;
				skillInfo.heal_MP += 10;
				System.out.println("파이어볼의 공격력 : " + skillInfo.fireball);
				System.out.println("힐의 회복량 : " + skillInfo.heal);
				
				System.out.println("마을로 돌아갑니다.");
				//마법 강화제 소모
				c.itemBag.remove("마법강화제");
				//강화의 실패했을경우
				
			}else {
				System.out.println("강화에 실패하였습니다.");
				System.out.println("마을로 돌아갑니다.");
				//마법 강화제 소모
				c.itemBag.remove("마법강화제");
			}
		//아니오를 선택시
		}else {
			System.out.println("마을로 돌아갑니다.");
		}
		
		}else {
			System.out.println("마법에 필요한 마법강화제가 부족합니다");
			System.out.println("마을로 돌아갑니다.");
			
		}
	}
	

}

