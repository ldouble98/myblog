package filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import entity.User;

public class ForeAuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String contextPath = request.getServletContext().getContextPath();
		String[] noNeedAuth = new String[] {"register", "login","checkLogin","user" };
		String uri = request.getRequestURI();

		uri = StringUtils.remove(uri, contextPath);
//		if(null!=uri&&uri.endsWith(".jsp")){
//			return;
//		}

		if (uri.startsWith("/fore") && !uri.startsWith("/foreServlet")) {
			String method = StringUtils.substringAfterLast(uri, "/fore");
			if (!Arrays.asList(noNeedAuth).contains(method)) {
//		System.out.println(uri);
		
//			if(!uri.equals("/forelogin")&&!uri.startsWith("/foreServlet")){
//				if("/login.jsp".equals(uri)){
//					response.sendRedirect("forelogin");
//				}
//				else{
					User user = (User) request.getSession().getAttribute("user");
					if (null == user) {
						response.sendRedirect("forelogin");
	//					request.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
						return;
					}
	
				}
		}
		
		arg2.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
