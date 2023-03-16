package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Role;
import util.DBConnectionUtil;

public class RoleDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	

	public ArrayList<Role> getItems() {
		ArrayList<Role> items = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM role";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Role item = new Role(id, name);
				items.add(item);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return items;
	}





}
