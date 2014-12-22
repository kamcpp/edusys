package org.labcrypto.edusys.department_report_portal.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getSession().getAttribute("token") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            res.sendRedirect(req.getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {
    }
}
