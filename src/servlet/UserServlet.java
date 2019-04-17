package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Page;
import entity.User;

public class UserServlet extends BaseBackServlet {
	public String show(HttpServletRequest request,HttpServletResponse response, Page page){
//		User user = (User)request.getSession().getAttribute("user");
//		if(null==user){
//			return "@forelogin";
//		}
		return "personal_message.jsp";
	}
	public String updatepassword(HttpServletRequest request, HttpServletResponse response, Page page){
		String password = request.getParameter("password");
//		System.out.println(password);
		User user = (User)request.getSession().getAttribute("user");
		user.setPassword(password);
		userDao.update(user);
		request.getSession().removeAttribute("user");
		return "%success";
	}
	public String updatename(HttpServletRequest request,HttpServletResponse response, Page page){
		String userName = request.getParameter("userName");
		System.out.println(userName);
		User user =userDao.get(userName);
		if(null==user){
			user = (User)request.getSession().getAttribute("user");
			user.setName(userName);
			userDao.update(user);
			return "%success";
			}
		else
		{
			return "%fail";
		}
	}
}
