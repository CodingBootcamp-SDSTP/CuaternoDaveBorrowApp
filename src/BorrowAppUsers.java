import java.sql.Date;

public class BorrowAppUsers
{
	public static class BorrowAppUsersBuilder {
		private String username;
		private String password;
		private String firstName;
		private String lastName;
		private int age;
		private String contact;
		private String email;
		private String role;

		public BorrowAppUsersBuilder username(String u) {
			username = u;
			return(this);
		}

		public BorrowAppUsersBuilder password(String p) {
			password = p;
			return(this);
		}

		public BorrowAppUsersBuilder firstName(String f) {
			firstName = f;
			return(this);
		}

		public BorrowAppUsersBuilder lastName(String l) {
			lastName = l;
			return(this);
		}

		public BorrowAppUsersBuilder age(int a) {
			age = a;
			return(this);
		}

		public BorrowAppUsersBuilder contact(String c) {
			contact = c;
			return(this);
		}

		public BorrowAppUsersBuilder email(String e) {
			email = e;
			return(this);
		}

		public BorrowAppUsersBuilder role(String r) {
			role = r;
			return(this);
		}

		public BorrowAppUsers build() {
			return(new BorrowAppUsers(this));
		}

		public String getUserName() {
			return(username);
		}

		public String getPassword() {
			return(password);
		}

		public String getFirstName() {
			return(firstName);
		}

		public String getLastName() {
			return(lastName);
		}

		public int getAge() {
			return(age);
		}

		public String getContact() {
			return(contact);
		}

		public String getEmail() {
			return(email);
		}

		public String getRole() {
			return(role);
		}
	}

	final String USERNAME;
	final String PASSWORD;
	final String FIRSTNAME;
	final String LASTNAME;
	final int AGE;
	final String CONTACT;
	final String EMAIL;
	final String ROLE;

	private BorrowAppUsers(BorrowAppUsersBuilder b) {
		USERNAME = b.getUserName();
		PASSWORD = b. getPassword();
		FIRSTNAME = b.getFirstName();
		LASTNAME = b.getLastName();
		AGE = b.getAge();
		CONTACT = b.getContact();
		EMAIL = b.getEmail();
		ROLE = b.getRole();
	}

	public String getBorrowAppUsersXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<username>" + USERNAME + "</username>");
		sb.append("<firstname>" + FIRSTNAME + "</firstname>");
		sb.append("<lastname>" + LASTNAME + "</lastname>");
		sb.append("<age>" + AGE + "</age>");
		sb.append("<contact>" + CONTACT + "</contact>");
		sb.append("<email>" + EMAIL + "</email>");
		sb.append("<role>" + ROLE + "</role>");
		return(sb.toString());
	}
}
