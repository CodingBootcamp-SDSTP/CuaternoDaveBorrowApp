import java.sql.Date;

public class BorrowAppUsers
{
	static BorrowAppUsers _instance = null;

	public static BorrowAppUsers instance(String u, String p, String fn, String ln, int a, String c, String e, String r) {
		if(_instance == null) {
			_instance = new BorrowAppUsers(u, p, fn, ln, a, c, e, r);
		}
		return(_instance);
	}

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private String contact;
	private String email;
	private String role;

	public String getUserName() {
		return(username);
	}

	public void setUserName(String un) {
		username = un;
	}

	public String getPassword() {
		return(password);
	}

	public void setPassword(String p) {
		password = p;
	}

	public String getFirstName() {
		return(firstName);
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public String getLastName() {
		return(lastName);
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public int getAge() {
		return(age);
	}

	public void setAge(int a) {
		age = a;
	}

	public String getContact() {
		return(contact);
	}

	public void setContact(String c) {
		contact = c;
	}

	public String getEmail() {
		return(email);
	}

	public void setEmail(String e) {
		email = e;
	}

	public String getRole() {
		return(role);
	}

	public void setRole(String r) {
		role = r;
	}

	private BorrowAppUsers(String u, String p, String fn, String ln, int a, String c, String e, String r) {
		username = u;
		password = p;
		firstName = fn;
		lastName = ln;
		age = a;
		contact = c;
		email = e;
		role = r;
	}

	public String getBorrowAppUsersXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<username>" + getUserName() + "</username>");
		sb.append("<firstname>" + getFirstName() + "</firstname>");
		sb.append("<lastname>" + getLastName() + "</lastname>");
		sb.append("<age>" + getAge() + "</age>");
		sb.append("<contact>" + getContact() + "</contact>");
		sb.append("<email>" + getEmail() + "</email>");
		sb.append("<role>" + getRole() + "</role>");
		return(sb.toString());
	}
}
