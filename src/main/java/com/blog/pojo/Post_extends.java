package com.blog.pojo;

public class Post_extends {
    private Integer id;

    private Integer postId;

    private Integer browser;

    private Integer collect;

    private Integer praise;

    private Integer comment;

    
    public Post_extends(){}
    public Post_extends(Integer id, Integer postId, Integer browser, Integer collect, Integer praise, Integer comment) {
		super();
		this.id = id;
		this.postId = postId;
		this.browser = browser;
		this.collect = collect;
		this.praise = praise;
		this.comment = comment;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getBrowser() {
        return browser;
    }

    public void setBrowser(Integer browser) {
        this.browser = browser;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

	@Override
	public String toString() {
		return "Post_extends [id=" + id + ", postId=" + postId + ", browser=" + browser + ", collect=" + collect
				+ ", praise=" + praise + ", comment=" + comment + "]";
	}
    
}