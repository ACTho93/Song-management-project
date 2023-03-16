package model.bean;

public class Countlike {
	private int like_id;
	private int user_id;
	private int action_id;
	private int song_id;
	private int parent_like_id;
	private int count_like;
	public int getLike_id() {
		return like_id;
	}
	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAction_id() {
		return action_id;
	}
	public void setAction_id(int action_id) {
		this.action_id = action_id;
	}
	public int getSong_id() {
		return song_id;
	}
	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
	public int getParent_like_id() {
		return parent_like_id;
	}
	public void setParent_like_id(int parent_like_id) {
		this.parent_like_id = parent_like_id;
	}
	public int getCount_like() {
		return count_like;
	}
	public void setCount_like(int count_like) {
		this.count_like = count_like;
	}
	public Countlike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Countlike(int like_id, int user_id, int action_id, int song_id, int parent_like_id, int count_like) {
		super();
		this.like_id = like_id;
		this.user_id = user_id;
		this.action_id = action_id;
		this.song_id = song_id;
		this.parent_like_id = parent_like_id;
		this.count_like = count_like;
	}
	
	
	
}
