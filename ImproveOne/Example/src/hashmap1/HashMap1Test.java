package hashmap1;

import java.util.HashMap;
import java.util.Set;

public class HashMap1Test {

	public static void main(String[] args) {
		test();
	}
	
	/**
	 * 记录文章中出现的字符的次数
	 */
	private static void test() {
		String string="A man was blissfully driving along the highway, when he saw the Easter Bunny hopping across the middle of the road. He swerved to avoid hitting the Bunny, but unfortunately the rabbit jumped in front of his car and was hit. The basket of eggs went flying all over the place.\r\n" + 
				"The driver, being a sensitive man as well as an animal lover, pulled over to the side of the road, and got out to see what had become of the Bunny carrying the basket. Much to his dismay, the colorful Bunny was dead. The driver felt guilty and began to cry.\r\n" + 
				"A woman driving down the same highway saw the man crying on the side of the road and pulled over. She stepped out of her car and asked the man what was wrong.\r\n" + 
				"\"I feel terrible,\" he explained, \"I accidentally hit the Easter Bunny and killed it. There may not be an Easter because of me. What should I do?\"\r\n" + 
				"The woman told the man not to worry. She knew exactly what to do. She went to her car trunk, and pulled out a spray can. She walked over to the limp, dead Bunny, and sprayed the entire contents of the can onto the little furry animal.\r\n" + 
				"Miraculously the Easter Bunny came to back life, jumped up, picked up the spilled eggs and candy, waved its paw at the two humans and hopped on down the road. 50 yards away the Easter Bunny stopped, turned around, waved and hopped on down the road another 50 yards, turned, waved, hopped another 50 yards and waved again!\r\n" + 
				"The man was astonished. He said to the woman, \"What in heaven's name is in your spray can? What was it that you sprayed on the Easter Bunny?\" The woman turned the can around so that the man could read the label. It said: \"Hair spray. Restores life to dead hair. Adds permanent wave.\"";
		HashMap<Character, Integer> data=new HashMap<>();
		for ( Character c : string.toCharArray()) {
			if (data.containsKey(c)) {//判断是否存在相同的key
				int count=data.get(c);
				count++;
				data.replace(c, count);//更新旧的次数
			}else {
				data.put(c, 1);//如果不存在,则添加
			}
		}
		
		Set<Character> keySet=data.keySet();
		for (char character : keySet) {
			int count=data.get(character);
			System.out.println("字符:'"+character+"'出现了"+count+"次");
		}
	}
}
