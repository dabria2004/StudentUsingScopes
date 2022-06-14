package studentregistration.model;

public class UserBean {
	private String userid;
	private String username;
	private String useremail;
	private String userpw;
	private String conpw;
	private String role;
	
	public UserBean() {
	
	}
	public UserBean(String userid, String username, String useremail, String userpw, String conpw, String role) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.userpw = userpw;
		this.conpw = conpw;
		this.role = role;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getConpw() {
		return conpw;
	}
	public void setConpw(String conpw) {
		this.conpw = conpw;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserBean [userid=" + userid + ", username=" + username + ", useremail=" + useremail + ", userpw="
				+ userpw + ", conpw=" + conpw + ", role=" + role + "]";
	}
	
}
