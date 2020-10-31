package textgame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharInfo {
	
	// 싱글톤 패턴
	private static CharInfo charInfo = new CharInfo();

	 int HERO_LV;
	 int HERO_HP;
	 int HERO_HP_MAX;
	 int HERO_MP;
	 int HERO_MP_MAX;

	 int STR;
	 int INT;
	 int CON;
	 int DEX;

	 int DMG;
	 int EXP;
	 int[] EXP_TABLE= { 0, 200, 400, 600, 800, 1000 };
	 int GOLD;
	 List<String> itemBag = new ArrayList<String>();
	 int itemBagSize;

	public CharInfo() {
		//최초 시작일 때의 유저 체크
		if(charInfo ==null) {
			this.HERO_LV = 1;
			this.HERO_HP = 100;
			this.HERO_HP_MAX = 100;
			this.HERO_MP = 100;
			this.HERO_MP_MAX = 100;
			this.STR = 5;
			this.INT = 5;
			this.CON = 5;
			this.DEX = 5;
			this.DMG = 5;
			this.EXP = 0;
			this.GOLD = 100;
			this.itemBagSize = 10;
			this.itemBag.add("마법강화제");
		}
	}
	
	// 새 게임을 시작하는 유저 체크 or 불러오기(null 체크)
	public static CharInfo loadCharInfo() {
		return charInfo;
	}
	
	//유저체력 보정
	void modeCharInfo(CharInfo c) throws IOException{
		//조건 : 현재 캐릭터 체력이 최대체력보다 높을경우 현재체력을 최대체력만큼 맞춘다.
		if(c.HERO_HP > c.HERO_HP_MAX) {
			c.HERO_HP = c.HERO_HP_MAX;
		}
		if(c.HERO_MP > c.HERO_MP_MAX) {
			c.HERO_MP= c.HERO_MP_MAX;
		}
		if(c.HERO_MP < 0 ) {
			c.HERO_MP = 0;
		}
		if(c.HERO_HP <= 0) {
			c.HERO_HP = 0;
			System.out.println("주인공이 쓰러졌습니다.");
			GameStart.main(null);
		}
	}
	
	void setStatus(CharInfo c) {
		System.out.println("LV : "+c.HERO_LV);
		System.out.println("HP : "+c.HERO_HP+"/"+c.HERO_HP_MAX);
		System.out.println("MP : "+c.HERO_MP+"/"+c.HERO_MP_MAX);
		System.out.println("STR: "+c.STR);
		System.out.println("INT: "+c.INT);
		System.out.println("CON : "+c.CON);
		System.out.println("DEX : "+c.DEX);
		System.out.println("데미지 : "+c.DMG);
		System.out.println("GOLD : "+c.GOLD);
	}
	
	//일정 수준의 경험치를 획득시 레벨업 및 스테이터스 증가
	void setLv(CharInfo c) {
		//조건 : 현재캐릭터의 경험치가 경험치 테이블의 수치보다 높거나 같을경우,
		//레벨 +1, 최대체력 마력+ 100,현재체력 , 마력을 최대마력과 같게
		//STR,EX,CON,INT를 1씩증가
		System.out.println("경험치 : " + c.EXP +"/"+c.EXP_TABLE[c.HERO_LV]);
		if(EXP >= c.EXP_TABLE[c.HERO_LV]) {
			c.HERO_LV++;
			c.HERO_HP_MAX +=100;
			c.HERO_MP_MAX +=100;
			c.HERO_HP = c.HERO_HP_MAX;
			c.HERO_MP = c.HERO_MP_MAX;
			c.STR++;
			c.DEX++;
			c.INT++;
			c.CON++;
			
			
		}
	}
	
}
