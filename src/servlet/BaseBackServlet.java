package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Page;
import dao.ArticleDao;
import dao.UserDao;

public class BaseBackServlet extends HttpServlet {
	protected UserDao userDao = new UserDao();
	protected ArticleDao articleDao = new ArticleDao();

	public void service(HttpServletRequest request, HttpServletResponse response) {
		String method = (String) request.getAttribute("method");

		Method m;
		try {
			int start = 0;
			int count = 13;
			try {
				start = Integer.parseInt(request.getParameter("page.start"));
			} catch (Exception e) {
				
			}
			try {
				count = Integer.parseInt(request.getParameter("page.count"));
			} catch (Exception e) {
			}
			Page page = new Page(start, count);
			m = this.getClass().getMethod(method,
					javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class, Page.class);
			String redirect = m.invoke(this, request, response, page)
					.toString();
			if (redirect.startsWith("@")) {
				response.sendRedirect(redirect.substring(1));
			} else if (redirect.startsWith("%")) {
				// System.out.println(redirect.substring(1));

				response.getWriter().print(redirect.substring(1));
			} else {
				request.getRequestDispatcher(redirect).forward(request,
						response);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
