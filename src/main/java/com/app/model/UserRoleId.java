package com.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRoleId implements Serializable {
	private static final long serialVersionUID = 8873015071621580930L;
	
	@Column(name = "role_id", nullable = false, length = 50)
	private String roleId;
	
	@Column(name = "user_name", nullable = false, length = 50)
	private String userName;
}
