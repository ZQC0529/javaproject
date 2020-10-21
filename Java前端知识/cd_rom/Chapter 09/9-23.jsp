<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="javax.xml.parsers.*"%>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.transform.*" %>
<%@ page import="javax.xml.transform.dom.DOMSource" %>
<%@ page import="javax.xml.transform.stream.StreamResult" %>
<%!
NodeList links = null;
Document doc = null;
%>
<%
String name = "zhourunfa";
String email = "zhourunfa@tom.com";
String filename = "";
filename = getServletConfig().getServletContext().getRealPath ("9-21.xml");

try {
   	  // 为解析XML文件创建DOM对象
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder=factory.newDocumentBuilder();
      doc=builder.parse(new File(filename));
      // 初始化
      doc.normalize();
      // 得到节点集合
      links =doc.getElementsByTagName("person");
}catch(Exception e) {
       out.println("访问XML文件出错！");
	   return;
}
// 下面构造一组新的节点
try{
    Element root = doc.getDocumentElement();
    Node node_list = doc.createElement("person");
    
    Node node_name = (Node) doc.createElement("name");
    Node tmp1 = doc.createTextNode("tmp1");
    tmp1.setNodeValue( "zhourunfa" );
    node_name.appendChild(tmp1);
    
    Node node_email = doc.createElement("email");
    Node tmp5 = doc.createTextNode("tmp5");
    tmp5.setNodeValue( "zhouruanfa@tom.com" );
    node_email.appendChild(tmp5);
    
    node_list.appendChild( node_name ); 
    node_list.appendChild( node_email );
     
    root.appendChild(node_list);

    TransformerFactory tFactory =TransformerFactory.newInstance();
	Transformer transformer = tFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File( filename ));
	transformer.transform(source, result);    
  }catch(Exception e){
	  out.print(e);
}
%>