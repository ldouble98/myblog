package servlet;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Page;
import entity.Article;
import entity.User;

public class ArticleServlet extends BaseBackServlet {

	public String show(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user = (User) request.getSession().getAttribute("user");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String category = request.getParameter("category");
		List<Article> articles = null;
//		articles = articleDao.getAllArticle(user);
		int totalpage = (int)request.getSession().getAttribute("totalArticle");
		page.setTotal(totalpage);
		request.setAttribute("page", page);
		articles = articleDao.list(user, page.getStart(), page.getCount());
//		System.out.println(page.getStart()+"***"+page.getCount());
		request.setAttribute("articles", articles);
		return "showArticleCategory.jsp";
	}

	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user = (User) request.getSession().getAttribute("user");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		System.out.println(title + content + category);
		Article article = new Article();
		article.setTitle(title);
		article.setCategory(category);
		article.setContent(content);
		article.setCreateDate(new Date());
		article.setUser(user);
		articleDao.add(article);
		return "@forehome";
	}

	public String del(HttpServletRequest request, HttpServletResponse response, Page page) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		articleDao.delete(aid);
		User user = (User) request.getSession().getAttribute("user");
		int totalArticle = articleDao.getTotal(user);
		request.getSession().setAttribute("totalArticle", totalArticle);
		Map<String, Integer> each_category = articleDao
				.getTotal_by_eachcategory(user);
		request.getSession().setAttribute("each_category", each_category);
		return "@admin_article_show";
	}

	public String update(HttpServletRequest request,
			HttpServletResponse response, Page page) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		return "";
	}
	public String showblog(HttpServletRequest request,
			HttpServletResponse response, Page page) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		Article article = articleDao.getBlog(aid);
		request.setAttribute("article", article);
		return "showBlog.jsp";
	}
}
