<%@ page contentType="text/html;charset=GB2312" %>
<%@ page import="org.jdom.*"%> 
<%@ page import="org.jdom.input.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%
try {
	SAXBuilder sax = new SAXBuilder();
	String ss = "<?xml version='1.0' encoding='GB2312'?><Groups>" +
	"<group ID='101' GroupName='清华' GroupDescription='TSU'/>" +
	"<group ID='123' GroupName='北大' GroupDescription='pku'/>" +
	"</Groups>";
	StringBuffer bb = new StringBuffer(ss);
	ByteArrayInputStream bi = new ByteArrayInputStream(ss.getBytes());
	Document doc = sax.build(bi);
	List l=doc.getRootElement().getChildren("group");
	for(int i=0;i<l.size();i++)    {
            Element e = (Element)l.get(i);
        	out.println("<BR>");
        	out.println(e.getAttributeValue("ID"));
        	out.println(e.getAttributeValue("GroupName"));
            }
}
catch (Exception e) {
	out.println("found Exception!!!!!!!!!!"+e);
}
%>