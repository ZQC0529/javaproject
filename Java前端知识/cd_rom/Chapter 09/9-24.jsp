<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="org.jdom.*"%> 
<%@ page import="org.jdom.input.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%
String filename = "";
filename = getServletConfig().getServletContext().getRealPath ("9-21.xml");
try {
	SAXBuilder sax = new SAXBuilder();
	Document doc = sax.build(new FileInputStream(filename));
	List l=doc.getRootElement().getChildren("person");
	for(int i=0;i<l.size();i++)    {
            Element e = (Element)l.get(i);
        	out.println("<BR>");
        	out.println(e.getChild("name").getText());
        	out.println(e.getChild("email").getText());
            }
}
catch (Exception e) {
	out.println("found Exception!!!!!!!!!!"+e);
}
%>