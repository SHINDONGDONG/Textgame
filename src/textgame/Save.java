package textgame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;;

public class Save {

	public void save(CharInfo c) throws IOException{
		//입출력기능 버퍼드라이트
		
	BufferedWriter write= new BufferedWriter(new FileWriter("save.txt"));

	write.append(Integer.toString(c.HERO_HP));
	//줄바꿈
	write.newLine();
	write.append(Integer.toString(c.HERO_HP_MAX));
	write.newLine();
	write.append(Integer.toString(c.HERO_MP));
	write.newLine();
	write.append(Integer.toString(c.HERO_MP_MAX));
	write.newLine();
	write.append(Integer.toString(c.HERO_LV));
	write.newLine();
	write.append(Integer.toString(c.EXP));
	write.newLine();
	write.append(Integer.toString(c.DMG));
	write.newLine();
	write.append(Integer.toString(c.GOLD));
	write.newLine();
	
	for(String item : c.itemBag) {
		write.append(item);
		write.append(",");
	}
	write.newLine();
	//남아있는 데이터 모두출력
	write.flush();
	write.close();
	}
	
	public void load() throws NumberFormatException, IOException {
		CharInfo c = new CharInfo();
		
		BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
		
		c.HERO_HP = Integer.parseInt(reader.readLine());
		c.HERO_HP_MAX = Integer.parseInt(reader.readLine());
		c.HERO_MP = Integer.parseInt(reader.readLine());
		c.HERO_MP_MAX = Integer.parseInt(reader.readLine());
		c.HERO_LV = Integer.parseInt(reader.readLine());
		c.EXP = Integer.parseInt(reader.readLine());
		c.DMG = Integer.parseInt(reader.readLine());
		c.GOLD = Integer.parseInt(reader.readLine());
		
		String[] itemArr = reader.readLine().split(",");
		
		for(String item : itemArr) {
			
			c.itemBag.add(item);
			
		}
		
		CharInfo.setCharInfo(c);
		
		
		
		
	}
	
}
