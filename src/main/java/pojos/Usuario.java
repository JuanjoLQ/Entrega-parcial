package pojos;

public class Usuario {
	
	private String username = "";
	private String pass = "";
	private Boolean admin = false;

	public Usuario(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}
	
	public Usuario(String username, String pass, Boolean admin) {
		super();
		this.username = username;
		this.pass = pass;
		this.admin = admin;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	

}
