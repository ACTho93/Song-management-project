package model.bean;

public class Comment {
	private int id;
	private int id_songs;
	private String comment;
	private String rep_comment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_songs() {
		return id_songs;
	}
	public void setId_songs(int id_songs) {
		this.id_songs = id_songs;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getRep_comment() {
		return rep_comment;
	}
	public void setRep_comment(String rep_comment) {
		this.rep_comment = rep_comment;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Comment(int id, int id_songs, String comment) {
		super();
		this.id = id;
		this.id_songs = id_songs;
		this.comment = comment;
	}
	public Comment(int id, int id_songs, String comment, String rep_comment) {
		super();
		this.id = id;
		this.id_songs = id_songs;
		this.comment = comment;
		this.rep_comment = rep_comment;
	}
	
	
	
	

	
	

	
	
	
}
