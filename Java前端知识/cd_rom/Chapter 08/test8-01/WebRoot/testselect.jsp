<%@ page language="java" import="java.util.*,org.hibernate.Session,
	org.hibernate.Transaction,com.SessionFactory,org.hibernate.Query,
	org.hibernate.cfg.Configuration,com.orm.Usertab" pageEncoding="gb2312"%>
<%
	Session s = SessionFactory.getSession();
	Query q = s.createQuery("from Usertab");
	List list = q.list();
	s.close();

	if(list.isEmpty())
	out.print("error!");
	else
	{  
		for (Iterator it = list.iterator(); it.hasNext(); ) 
		{
           Usertab ui = (Usertab) it.next();
           out.println(ui.getUserid());
           out.println(ui.getUsername());
           out.println(ui.getUserpwd());
           out.println("<BR>");
       }
	}
%>