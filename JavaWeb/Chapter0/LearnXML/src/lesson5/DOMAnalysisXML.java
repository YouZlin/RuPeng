package lesson5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class DOMAnalysisXML {
	private static DOMAnalysisXML domXML;
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		domXML=new DOMAnalysisXML();
		domXML.doAnalysis();
	}
	
	/**
	 * 执行XML解析
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	private  void doAnalysis() throws ParserConfigurationException, SAXException, IOException {
		//获得document对象
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		String path=DOMAnalysisXML.class.getResource("/lesson5/users.xml").getFile();
		Document document=documentBuilder.parse(path);
		
		//把users.xml文件的数据封装到List<User>对象里面
		List<User> userList=new ArrayList<>();
		
		//获取想要操作的元素
		NodeList userNodeList=document.getElementsByTagName("user");
//		只用xml使用了约束,并且设置了 id ID #REQUIRED	才允许使用getElementById
//		document.getElementById("u001");
		
		for (int i = 0; i < userNodeList.getLength(); i++) {
			User user=new User();
			
			Element userElement=(Element) userNodeList.item(i);
			//拿到element的子元素
			String id=userElement.getAttribute("id");
			String name=userElement.getAttribute("name");
			
			user.setId(id);
			user.setName(name);
			
			//拿到emial子元素对象
			NodeList emailNodeList=userElement.getElementsByTagName("email");
			for (int j = 0; j < emailNodeList.getLength(); j++) {
				Element emailElement=(Element) emailNodeList.item(j);
				String email=emailElement.getTextContent();
				//此处因邮箱只有一个,所以可以放在这里
				//不然应该像phones一样放在外部添加
				user.setEmail(email);
				
			}
			
			//存储phone数据
			List<String>phones=new ArrayList<>();
			//拿到phone子孙元素对象
			NodeList phoneNodeList=userElement.getElementsByTagName("phone");
			for (int m = 0; m < phoneNodeList.getLength(); m++) {
				Element phoneElement=(Element) phoneNodeList.item(m);
				String phone=phoneElement.getTextContent();
				phones.add(phone);
			}
			user.setPhones(phones);
			
			//user完成后添加进列表中
			userList.add(user);
		}
		
	}

}
