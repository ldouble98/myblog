package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import entity.User;

public class UserDao {
	public UserDao(){
		
	}
	public void add(User user) {
		String sql = "insert into user_ values(?,?,?)";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(User user) {
		String sql = "update user_ set name=?,email=?,password=? where id=?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getId());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public List<User> list(int start, int count){
		List<User> user = new ArrayList<User>();
		
		return user;
	} 
	
	public boolean isExixt(String name) {
		User user = get(name);
		return user != null;
	}

	public User get(String name) {
		User user = null;
		String sql = "select * from user_ where name=?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user.setId(id);
				user.setEmail(email);
				user.setName(name);
				user.setPassword(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public User get(String email, String password) {
		User user = null;
		String sql = "select * from user_ where email=? and password=?";
		try (Connection c = DBUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				user.setId(id);
				user.setEmail(email);
				user.setName(name);
				user.setPassword(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

}
