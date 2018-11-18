package lesson6;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 实现自己的处理器
 * 
 * @author Administrator
 * 
 */
public class UserXMLHandler extends DefaultHandler {
	private User user;
	private String content;// 临时记录文本内容
	

	public User getUser() {
		return user;
	}


	@Override
	public void startElement(String url, String localName, String qName,
			Attributes attrributes) throws SAXException {
//		System.out.println("读取到" + qName + "的开始标签");

		if ("user".equals(qName)) {
			user = new User();
			String id = attrributes.getValue("id");
			String name = attrributes.getValue("name");
			user.setId(id);
			user.setName(name);
		} else if ("email".equals(qName)) {
			//标签头部没有属性不做操作
		} else if ("phone".equals(qName)) {
			//标签头部没有属性不做操作
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
//		System.out.println("读取到一段文本内容:" + new String(ch, start, length));
		content = new String(ch, start, length);//获得标签内部的文本内容
	}

	@Override
	public void endElement(String url, String localName, String qName)
			throws SAXException {
//		System.out.println("读取到" + qName + "的结束标签");
		if ("user".equals(qName)) {
			
		} else if ("email".equals(qName)) {
			user.setEmail(content);
		} else if ("phone".equals(qName)) {
			user.setPhone(content);
		}
	}
	
}
