package tk.bluebells.servlet;

public class User {
	String name;
	String pwd;
	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	//必须，否则无法访问：sessionScope.user.name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
