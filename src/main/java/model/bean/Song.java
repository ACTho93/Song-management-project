package model.bean;

import java.sql.Timestamp;

public class Song {
	private int id;
	private String name;
	private String previewText;
	private String detailText;
	private Timestamp dateCreate;
	private String picture;
	private int counter;
	private Category category;
	private int id_userlogin;
	private int countlike;
	
	
	
	
	public int getCountlike() {
		return countlike;
	}
	public void setCountlike(int countlike) {
		this.countlike = countlike;
	}
	public int getId_userlogin() {
		return id_userlogin;
	}
	public void setId_userlogin(int id_userlogin) {
		this.id_userlogin = id_userlogin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreviewText() {
		return previewText;
	}
	public void setPreviewText(String previewText) {
		this.previewText = previewText;
	}
	public String getDetailText() {
		return detailText;
	}
	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}
	public Timestamp getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Song(int id, String name, String previewText, String detailText, Timestamp dateCreate, String picture,
			int counter, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.previewText = previewText;
		this.detailText = detailText;
		this.dateCreate = dateCreate;
		this.picture = picture;
		this.counter = counter;
		this.category = category;
	}
	public Song(int id, String name, String previewText, String detailText, Timestamp dateCreate, String picture,
			int counter, Category category, int id_userlogin) {
		super();
		this.id = id;
		this.name = name;
		this.previewText = previewText;
		this.detailText = detailText;
		this.dateCreate = dateCreate;
		this.picture = picture;
		this.counter = counter;
		this.category = category;
		this.id_userlogin = id_userlogin;
	}
	public Song(int id, String name, String previewText, String detailText, Timestamp dateCreate, String picture,
			int counter, Category category, int id_userlogin, int countlike) {
		super();
		this.id = id;
		this.name = name;
		this.previewText = previewText;
		this.detailText = detailText;
		this.dateCreate = dateCreate;
		this.picture = picture;
		this.counter = counter;
		this.category = category;
		this.id_userlogin = id_userlogin;
		this.countlike = countlike;
	}
	
	
	
	
	
	
}
