package pl.coderslab.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/user/*", "/admin/*"})
@WebFilter(urlPatterns = {"/next/*"})
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession();

        if (session.getAttribute("admin") == null) {
            ((HttpServletResponse) response).sendRedirect(request1.getContextPath() + "/login");
        } else {
            chain.doFilter(request, response);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
