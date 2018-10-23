package list1;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListTest1 {

	public static void main(String[] args) {
		//信息文件存在当前类同一层,获得相对应得URL,会头部会多出file:/,可在浏览器中打开查看
		URL file=ListTest1.class.getResource("PeopleInfo.txt");
		System.out.println(file.getFile().substring(1));//转成文件格式,头部会多一个"/"
		try {
			List<Person>people=readAllInfo(file.getFile().substring(1));
			//输出是否读取成功
			for(Person person:people) {
				System.out.println("read:Name="+person.getName()+",Age="+person.getAge()+",Phone="+person.getPhone());
			}
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("没有该文件");
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("读取文件失败");
		}
	}
	
	private static List<Person>  readAllInfo(String file) throws IOException {
		ArrayList<Person> arrayList=new ArrayList<>();
		FileInputStream fis=null;
		InputStreamReader reader=null;
		BufferedReader buffReader=null;
		try {
			fis=new FileInputStream(file);
			reader=new InputStreamReader(fis);
			buffReader=new BufferedReader(reader);
			String line=null;
			while ((line=buffReader.readLine())!=null) {
				String[]strs=line.split(" ");
				Person person=new Person();
				person.setName(strs[0]);
				person.setAge(Integer.parseInt(strs[1]));
				person.setPhone(strs[2]);	
				arrayList.add(person);
			}
		} finally {
			close(buffReader);
			close(reader);
			close(fis);
		}
		return arrayList;
	}
	
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
