package com.yanzhuang.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsynServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/demo" })
public class AsynServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ThreadPoolExecutor threadPoolExcutor=new ThreadPoolExecutor(10, 20, 20L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsynServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("==== asychon  页面加载开始====<hr />");
        AsyncContext actx = request.startAsync();
        actx.setTimeout(30 * 3000);
       // actx.start(new MyThread(actx));
        threadPoolExcutor.execute(new MyThread(actx));
      
        out.println("====  asychon 页面加载结束====<hr />");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        System.out.println("over....!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

class MyThread implements Runnable 
{
    private AsyncContext actx;
 
    public MyThread(AsyncContext actx) {
        this.actx = actx;
    }
 
    public void run() {
        try {
        	System.out.println("------");
            Thread.sleep(10 * 1000); // ����5��
            
            PrintWriter out = actx.getResponse().getWriter();

            out.println("hello servlet3.<br/>");

            out.flush();

            actx.complete();
        }
        catch (Exception e) {
        }
    }
}
