package com.blog.pojo;

public class User {
    private Integer id;

    private String username;

    private String passwordHash;

    private String email;

    private String question;

    private String answer;

    private Short status;

    private String createdAt;

    private String updatedAt;

    public User() {
		super();
	}
  
	public User(String username, String passwordHash, String email, String question, String answer
			) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.createdAt = (System.currentTimeMillis()/1000)+"";
		this.updatedAt =createdAt;
	}
	
	public User(Integer id, String username, String passwordHash, String email, String question, String answer) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.updatedAt = (System.currentTimeMillis()/1000)+"";
	}
	
	public User(Integer id, String username, String passwordHash, String email, String question, String answer,
			Short status, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash == null ? null : passwordHash.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", email=" + email
				+ ", question=" + question + ", answer=" + answer + ", status=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
    
    
}