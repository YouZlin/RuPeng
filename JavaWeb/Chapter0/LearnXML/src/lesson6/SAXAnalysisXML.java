package lesson6;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SAXAnalysisXML {
	private static SAXAnalysisXML saxXML;
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		saxXML=new SAXAnalysisXML();
		saxXML.doAnalysis();
	}
	
	/**
	 * 执行sax解析
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	private void doAnalysis() throws ParserConfigurationException, SAXException, IOException{
		/*
		 * SAX解析基本思路执行三个动作
		 * <user id="u001" name="蛋蛋"> startElement
				<email>					startElement
					85740295@qq.com		charaters
				</email>				endElement
				<phone>					startElement
					186948659604		charaters
				</phone>				endElement
			</user>						endElement
		 */
		
		File xmlFile=new File(SAXAnalysisXML.class.getResource("/lesson6/user.xml").getFile());
		UserXMLHandler userXMLHandler=new UserXMLHandler();
		
		SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
		SAXParser saxParser=saxParserFactory.newSAXParser();
		saxParser.parse(xmlFile, userXMLHandler);
		
		User user=userXMLHandler.getUser();
		System.out.println(user);
		
	}

}
