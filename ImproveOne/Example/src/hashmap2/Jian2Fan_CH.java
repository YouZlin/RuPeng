package hashmap2;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 汉字的简体装换成繁体类
 */
public class Jian2Fan_CH {
	private static final String j2fPath;
	private static final HashMap<Character,  Character> data;
	static{
			try {
				j2fPath =Jian2Fan_CH.class.getResource("jf_map_utf8.properties").getFile().substring(1);
				data=Jian2Fan_UTF8(j2fPath);
			} catch (IOException e) {
				throw new RuntimeException("加载简繁体转换字体库失败", e);
			}
	}
	
	/**
	 * 从字库的路径中或的字库数据
	 * @param path 字库路径
	 * @return 字库数据
	 * @throws IOException
	 */
	private static HashMap<Character,  Character> Jian2Fan_UTF8(String path) throws IOException {
		HashMap<Character,  Character> hashMap=new HashMap<>();
		FileInputStream fis=null;
		InputStreamReader reader=null;
		BufferedReader buffReader=null;
		try {
			fis=new FileInputStream(path);
			reader=new InputStreamReader(fis,"UTF-8");
			buffReader=new BufferedReader(reader);
			String line=null;
			while ((line=buffReader.readLine())!=null) {
				char chJian=line.charAt(0);
				char chFan=line.charAt(2);
				hashMap.put(chJian, chFan);
			}
		} finally {
			close(buffReader);
			close(reader);
			close(fis);
		}
		return hashMap;
	}
	
	/**
	 * 对简体进行转换
	 * @param str 需要转换的字符串
	 * @return 繁体字符串
	 */
	public static String convert(String str) {
		StringBuilder sb=new StringBuilder();
		for(char c:str.toCharArray()) {
			if (data.containsKey(c)) {
				char fan=data.get(c);
				sb.append(fan);
			}else {//字库中没有繁体,,直接添加
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * 关闭数据流
	 * @param close
	 */
 	private static void close(Closeable close){
		if (close!=null) {
			try {
				close.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
