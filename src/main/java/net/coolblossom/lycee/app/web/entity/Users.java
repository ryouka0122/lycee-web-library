package net.coolblossom.lycee.app.web.entity;

public class Users {

	public String userId;

	public String userName;

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "userId:" + userId + " / userName:"+ userName;
	}

}
