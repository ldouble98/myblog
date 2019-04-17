package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
import util.DateUtil;
import entity.Article;
import entity.User;

public class ArticleDao {
	public ArticleDao() {

	}

	public void update(Article article) {
		String sql = "update article set title=?,content=?,category=?,createDate=?,uid=? where id=?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setString(3, article.getCategory());
			ps.setDate(4, DateUtil.d2t(article.getCreateDate()));
			ps.setInt(5, article.getUser().getId());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(Article article) {
		String sql = "insert into article values(?,?,?,?,?)";

		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setString(3, article.getCategory());
			ps.setDate(4, DateUtil.d2t(article.getCreateDate()));
			ps.setInt(5, article.getUser().getId());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String sql = "delete from article where id =?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getTotal(User user) {
		int total = 0;
		String sql = "select count(*) from article where uid =?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, user.getId());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				total = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}

	public Map<String, Integer> getTotal_by_eachcategory(User user) {
		int total = 0;
		List<String> categorys = new CategoryDao().getCategory();
		Map<String, Integer> each_category = new TreeMap<>();
		for (String category : categorys) {
			String sql = "select count(*) from article where uid =? and category=?";
			try (Connection c = DBUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
				ps.setInt(1, user.getId());
				ps.setString(2, category);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					total = rs.getInt(1);
					each_category.put(category, total);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return each_category;
	}

	public List<Article> getAllArticle(User user) {
		List<Article> articles = new ArrayList<Article>();
		Article article = null;
		String sql = "select * from article where uid=? order by createDate desc";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				article = new Article();
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String category = rs.getString("category");
				Date createDate = DateUtil.t2d(rs.getDate("createDate"));

				article.setCategory(category);
				article.setCreateDate(createDate);
				article.setContent(content);
				article.setId(id);
				article.setTitle(title);
				article.setUser(user);

				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;

	}

	public List<Article> getEachCategoryArticle(User user, String eachCategory) {
		List<Article> articles = new ArrayList<Article>();
		Article article = null;
		String sql = "select * from article where uid=? where category=? order by createDate desc";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, user.getId());
			ps.setString(2, eachCategory);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				article = new Article();
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createDate = DateUtil.t2d(rs.getDate("createDate"));

				article.setCategory(eachCategory);
				article.setCreateDate(createDate);
				article.setContent(content);
				article.setId(id);
				article.setTitle(title);
				article.setUser(user);

				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
	
	public Article getBlog(int id){
		String sql = "select * from article where id=?";
		Article article = null;
		try(Connection cn =DBUtil.getConnection();PreparedStatement ps = cn.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				article = new Article();
				String content =  rs.getString("content");
				String title = rs.getString("title");;
				Date createDate = DateUtil.t2d(rs.getDate("createDate"));
				String category = rs.getString("category");
				
				article.setCategory(category);
				article.setCreateDate(createDate);
				article.setContent(content);
				article.setId(id);
				article.setTitle(title);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}
	
	/**
	 *  sql server ∑÷“≥≤È—Ø
	 * */
	public List<Article> list(User user,int start,int end){
		List<Article> articles = new ArrayList<Article>();
		Article article = null;
		String sql = "select top(?) * from article where id not in (select top(?) id from article where uid=? order by createDate desc) and uid=? order by createDate desc";
		try(Connection cn =DBUtil.getConnection();PreparedStatement ps = cn.prepareStatement(sql)){
			ps.setInt(1, end);
			ps.setInt(2, start);
			ps.setInt(3, user.getId());
			ps.setInt(4, user.getId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				article = new Article();
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date createDate = DateUtil.t2d(rs.getDate("createDate"));
				String eachCategory = rs.getString("category");
				
				article.setCategory(eachCategory);
				article.setCreateDate(createDate);
				article.setContent(content);
				article.setId(id);
				article.setTitle(title);
				article.setUser(user);

				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
}
