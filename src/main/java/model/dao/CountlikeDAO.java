package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Comment;
import model.bean.Countlike;
import util.DBConnectionUtil;

public class CountlikeDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<Countlike> getItems() {
		ArrayList<Countlike> items = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM countlike";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				int like_id = rs.getInt("like_id");
				int user_id = rs.getInt("user_id");
				int action_id = rs.getInt("action_id");
				int song_id = rs.getInt("song_id");
				int parent_like_id = rs.getInt("parent_like_id");
				int count_like = rs.getInt("count_like");
				
				Countlike item = new Countlike(like_id, user_id, action_id, song_id, parent_like_id, count_like);
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

	public int addCountlike(Comment objCmt) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO comment(id_songs, comment) VALUES(?, ?)";

		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, objCmt.getId_songs());
			pst.setString(2, objCmt.getComment());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pst != null && conn != null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
		return result;
	}

}
