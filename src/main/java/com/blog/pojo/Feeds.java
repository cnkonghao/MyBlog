package com.blog.pojo;

public class Feeds {
    private Integer id;
    
    public String user;

	private String content;

	private String createdAt;

	public Feeds() {
		super();
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Feeds(String user, String content) {
		super();
		this.user = user;
		this.content = content;
		this.createdAt = (System.currentTimeMillis()/1000)+"";
	}

	public Feeds(Integer id, String user, String content, String createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Feeds [id=" + id + ", user=" + user + ", content=" + content + ", createdAt=" + createdAt + "]";
	}
	
}