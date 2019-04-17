package Test;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import dao.ArticleDao;
import dao.UserDao;
import entity.Article;
import entity.User;

public class Test {
	public static void main(String[] args) {
		String str = "/foreadssads/foreasd";
		System.out.println(StringUtils.substringAfter(str, "/fore"));
		System.out.println(StringUtils.substringAfterLast(str, "/fore"));
		System.out.println(StringUtils.substringBefore(str, "ads"));
		System.out.println(StringUtils.substringBeforeLast(str, "ads"));
		
		
		UserDao dao = new UserDao();
		User user = dao.get("615838943@qq.com", "123456");
		System.out.println("****");
		ArticleDao artileDao = new ArticleDao();
		List<Article> allArticles = artileDao.list(user, 13, 13);
		System.out.println("---");
		System.out.println(allArticles);
		for(Article article:allArticles){
			System.out.println(article.getTitle());
		}
		
	}
}
