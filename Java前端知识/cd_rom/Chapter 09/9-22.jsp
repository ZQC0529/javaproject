<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="javax.xml.parsers.*"%> 
<%@ page import="org.w3c.dom.*"%> 
<%@ page import="java.io.*" %>
<%  
try{
	String filename = "";
	filename = getServletConfig().getServletContext().getRealPath("9-21.xml");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder=factory.newDocumentBuilder();
    Document doc=builder.parse(new File( filename ));
    NodeList nl =doc.getElementsByTagName("person");
    for (int i=0;i<nl.getLength();i++){
      Element node=(Element) nl.item(i);
      out.print("<BR>NAME: ");
      out.println(node.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
      out.print("ADDRESS: ");
      out.println(node.getElementsByTagName("email").item(0).getFirstChild().getNodeValue());
    }
    }catch(Exception e){
      e.printStackTrace();
	}
%>
