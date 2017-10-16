package com.blog.pojo;

public class Comment {
    private Integer id;

    private Integer postid;

    private Integer createdAt;

    private String username;

    private String content;

    public Comment(){}
	public Comment(Integer id, Integer postid, Integer createdAt, String username) {
		super();
		this.id = id;
		this.postid = postid;
		this.createdAt = createdAt;
		this.username = username;
	}
	public Comment(Integer id, Integer postid, Integer createdAt, String username, String content) {
		super();
		this.id = id;
		this.postid = postid;
		this.createdAt = createdAt;
		this.username = username;
		this.content = content;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
	@Override
	public String toString() {
		return "Comment [id=" + id + ", postid=" + postid + ", createdAt=" + createdAt + ", username=" + username
				+ ", content=" + content + "]";
	}
    
}