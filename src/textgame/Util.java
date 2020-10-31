package textgame;

public class Util {

	public int dice01() {
		
		int result = (int)(Math.random()*2);
		return result;
	}
	
	public boolean dice02() {
		boolean result = true;
		int randomInt = (int)(Math.random()*10)+1;
		if(randomInt <= 5) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}
}
