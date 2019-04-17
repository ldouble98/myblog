package servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Page;
import entity.User;

public class ForeServlet extends BaseForeServlet {

	public String login(HttpServletRequest request, HttpServletResponse response, Page page) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userDao.get(email, password);
		if (null == user) {
			request.setAttribute("msg", "账号密码错误");
			return "login.jsp";
		}
		request.getSession().setAttribute("user", user);

		return "@forehome";
	}

	public String home(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user = (User) request.getSession().getAttribute("user");
		int totalArticle = articleDao.getTotal(user);
		request.getSession().setAttribute("totalArticle", totalArticle);
		Map<String, Integer> each_category = articleDao
				.getTotal_by_eachcategory(user);
		request.getSession().setAttribute("each_category", each_category);
		System.out.println(each_category);
		return "home.jsp";
	}

	public String register(HttpServletRequest request,
			HttpServletResponse response, Page page) {
		String name = request.getParameter("userName");
		System.out.println(name);
		if (null == name) {
			System.out.println("****");
			return "register.jsp";
		}
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean isExixt = userDao.isExixt(name);
		if (isExixt) {
			request.setAttribute("msg", "用户名已经存在");
			return "register.jsp";
		}
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		userDao.add(user);
		return "@register_success.jsp";
	}

	public String checkLogin(HttpServletRequest request,
			HttpServletResponse response, Page page) {
		User user = (User) request.getSession().getAttribute("user");
		if (null != user) {
			return "%success";
		}
		return "%fail";
	}

	public String logout(HttpServletRequest request,
			HttpServletResponse response, Page page) {
		request.getSession().removeAttribute("user");
		return "@forelogin";
	}

	public String product(HttpServletRequest request,
			HttpServletResponse response, Page page) {
		int aid = Integer.parseInt(request.getParameter("aid"));

		return "";
	}

}
