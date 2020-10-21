import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.util.*;
import java.io.*;
import java.net.*;
class SAXReader extends DefaultHandler {
	// 使用栈来存储数据
	java.util.Stack tags=new java.util.Stack();
	// 定义和XML文件中标记对应的变量
	String name=null;
	String email=null;
	// 当遇到文档结束标记时会自动触发endDocument()方法
	public void endDocument() throws SAXException {
		System.out.println("------Parse End--------");
	}
	// 当遇到文档开始标记时会自动触发startDocument()方法
	public void startDocument() throws SAXException {
		System.out.println("------Parse Begin--------");
	}
	// 当遇到标记开始记时会自动触发startElement()方法
	public void startElement(String p0, String p1, String p2, Attributes p3) throws SAXException {
		// 参数p0对应的是名空间的URI，如没有则为空串
		// 参数p1对应的是名空间的局部名，如没有则为空串
		// 参数p2对应的是标记名
		// 参数p3对应的是属性名
		// System.out.println(p0 + ":" + p1 + ":" +p2);
		tags.push(p2);
	}
	public void endElement(String p0, String p1, String p2) throws SAXException {
		tags.pop();
		//一个link节点的信息收集齐了，将其格式化输出
		if (p2.equals("person")) printout();
	}
	// characters方法的第一个参数p0: 是包含字符串数据的字符数组
	// characters方法的第二个参数p1: 是起始位置
	// characters方法的第三个参数p2: 是结束位置
	// 注意：标记和标记之间的空格也会被计算
	public void characters(char[] p0, int p1, int p2) throws SAXException {
		//从栈中得到当前节点的信息
		String tag=(String) tags.peek();
		if (tag.equals("name")) name=new String(p0,p1,p2);
		else if (tag.equals("email")) email=new String(p0,p1,p2);
	}
	private void printout(){
		System.out.print("name: ");
		System.out.println(name);
		System.out.print("email: ");
		System.out.println(email);
	}
	static public void main(String[] args) {
		String filename = null;
		boolean validation = false;
		filename="9-21.xml";
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser=null;
		try {
			saxParser = spf.newSAXParser();
		} catch (Exception ex) {
			System.err.println(ex);
			System.exit(1);
		}
		try {
			saxParser.parse(new File(filename),new SAXReader());
		} catch (SAXException se) {
			System.err.println(se.getMessage());
			System.exit(1);
		} catch (IOException ioe) {
			System.err.println(ioe);
			System.exit(1);
		}
	}
}
