package objectLayer;

//A class that represents a registered user (that has an account)
public class RegisteredUser {
	private int id = 0;
	private String fName = null;
	private String lName = null;
	private String username = null;
	private String password = null;
	private String email = null;
	private int type = 0;
	
	public RegisteredUser(int id, String fName, String lName, String username, String password, String email, int type) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.type = type;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return this.fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return this.lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getType() {
		return this.type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
}
