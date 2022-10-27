package com.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDTO {
	
	@NotNull(message = "{user.id.absent}")
	private Integer userId;
	
	@NotNull(message = "{user.name.absent}")
	@Pattern(regexp = "([A-Za-z])+(\\s[A-Za-z]+)*",message = "{invalid.name.format}")
	private String userName;
	
	@NotNull(message = "{user.email.absent}")
	@Email
	@Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message = "{invalid.email.format}")
	private String userEmail;
	
	@NotNull(message = "{user.mobno.absent}")
	private Long userMobNo;
	
	

	public UserDTO() {
		super();

	}

	public UserDTO(Integer userId, String userName, String userEmail, Long userMobNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobNo = userMobNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getUserMobNo() {
		return userMobNo;
	}

	public void setUserMobNo(Long userMobNo) {
		this.userMobNo = userMobNo;
	}
	
	
	

}
