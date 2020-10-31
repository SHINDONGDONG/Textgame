package textgame;

public class Rest {

	public void doRest(CharInfo c) {
		System.out.println("휴식입니다.");
		System.out.println("주인공의 HP와 MP가 회복 되었습니다.");
		c.HERO_HP = c.HERO_HP_MAX;
		c.HERO_MP = c.HERO_MP_MAX;
	}
}
