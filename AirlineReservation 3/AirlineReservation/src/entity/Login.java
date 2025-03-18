package entity;

public class Login {
	private long user_mobile;
	private String user_password;

	public Login() {
		user_mobile = 0;
		user_password = "";
	}

	public Login(long user_mobile, String user_password) {
		super();
		this.user_mobile = user_mobile;
		this.user_password = user_password;
	}

	public long getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(long user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

}
