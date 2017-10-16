package com.blog.pojo;

public class Admin {
    private Integer id;

    private String username;

    private String authKey;

    private String passwordHash;

    private String email;

    private Short role;

    private Short status;

    private String avatar;

    private String createdAt;

    private String updatedAt;

    public Admin() {
		super();
	}

	public Admin(String username, String authKey, String passwordHash, String email, Short role, String avatar) {
		super();
		this.username = username;
		this.authKey = authKey;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
		this.avatar = avatar;
		this.createdAt = (System.currentTimeMillis()/1000)+"";
		this.updatedAt = createdAt;
	}

	public Admin(Integer id, String username, String authKey, String passwordHash, String email, Short role,
		 String avatar) {
		super();
		this.id = id;
		this.username = username;
		this.authKey = authKey;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
		this.status = status;
		this.avatar = avatar;
		this.updatedAt = (System.currentTimeMillis()/1000)+"";
	}

	public Admin(Integer id, String username, String authKey, String passwordHash, String email, Short role,
			Short status, String avatar, String  createdAt, String  updatedAt) {
		super();
		this.id = id;
		this.username = username;
		this.authKey = authKey;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
		this.status = status;
		this.avatar = avatar;
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

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey == null ? null : authKey.trim();
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

    public Short getRole() {
        return role;
    }

    public void setRole(Short role) {
        this.role = role;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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
		return "Admin [id=" + id + ", username=" + username + ", authKey=" + authKey + ", passwordHash=" + passwordHash
				+ ", email=" + email + ", role=" + role + ", status=" + status + ", avatar=" + avatar + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}