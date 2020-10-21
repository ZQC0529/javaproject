<%@ page language="java" import="java.util.*,org.hibernate.Session,
	org.hibernate.Transaction,com.SessionFactory,
	org.hibernate.cfg.Configuration,com.orm.Usertab" pageEncoding="gb2312"%>
<% 
   Session s = SessionFactory.getSession();
   org.hibernate.Transaction t = s.beginTransaction();
	Usertab u1 = new Usertab(); 
	u1.setUserid(new Integer("2"));
	u1.setUsername("John"); 
	u1.setUserpwd("1234");
	s.saveOrUpdate(u1); 
	t.commit(); 
	s.close(); 
%>
