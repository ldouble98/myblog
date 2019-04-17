package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.Category;

public class CategoryDao {
	public CategoryDao(){
		
	}
	
	public List<String> getCategory(){
		List<String> categorys = new ArrayList<>();
		Category category = null;
		String sql = "select * from category ";
		try(Connection c = DBUtil.getConnection();Statement st = c.createStatement()){
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				category = new Category();
				String catalog = rs.getString("category");
				category.setCategorys(catalog);
				categorys.add(catalog);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categorys;
	}
}
