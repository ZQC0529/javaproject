package org.zuel.course.ch05;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LoginListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        String param = context.getInitParameter("count");
        Integer count = new Integer(param);
        context.setAttribute("count", count);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
