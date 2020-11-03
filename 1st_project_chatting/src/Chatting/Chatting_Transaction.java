package Chatting;

public class Chatting_Transaction {
	
	 private String id;
	 private String password;
	 private String cCharac;
	 private String cGender;
	 
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcCharac() {
		return cCharac;
	}
	public void setcCharac(String cCharac) {
		this.cCharac = cCharac;
	}
	public String getcGender() {
		return cGender;
	}
	public void setcGender(String cGender) {
		this.cGender = cGender;
	}	 
	@Override
	public String toString() {
		
		return "id        : " + id + "PASSWORD  : " + password + "Character : " + cCharac + "Gendar   : " + cGender; 
	}
}


