package org.zuel.course.ch06.interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements Filter {

    private String loginUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.loginUrl = filterConfig.getInitParameter("noCheck");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if(session.getAttribute("login") == null && !loginUrl.contains(uri)) {
            ((HttpServletResponse) servletResponse).sendRedirect("/06/login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
