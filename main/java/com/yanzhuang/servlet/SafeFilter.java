package com.yanzhuang.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SafeFilter
 */
@WebFilter("/*")
public class SafeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SafeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest arg0=(HttpServletRequest)request;
		String uri=arg0.getRequestURI();
		//System.out.println(uri);
		/*if(!(uri.contains("login")||uri.contains("register")||uri.equals("/webStudentManager/")||uri.contains("image")))
		{
			HttpSession session=arg0.getSession();
			
			 if(session.getAttribute("log")==null)
				 return ;
			
		}*/
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
