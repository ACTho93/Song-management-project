package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Comment;
import util.DBConnectionUtil;

public class CommentDAO {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<Comment> getItems(int id) {
		ArrayList<Comment> items = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM comment WHERE id_songs = ?";

		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			
			while (rs.next()) {
				int cid = rs.getInt("id");
				int id_songs = rs.getInt("id_songs");
				String comment = rs.getString("comment");
				Comment item = new Comment(cid, id_songs, comment);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null && pst != null && conn != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return items;
	}

	public int addCMT(Comment objCmt) {
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
