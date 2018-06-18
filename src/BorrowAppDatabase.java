import java.sql.*;

public class BorrowAppDatabase
{
	static BorrowAppDatabase _instance = null;

	public static BorrowAppDatabase instance() {
		if(_instance == null) {
			_instance = new BorrowAppDatabase();
		}
		return(_instance);
	}

	private BorrowAppUsersCollection buc;

	public Connection getDb() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/dbborrowapp?user=user_BorrowApp&" + "password=borrowapp&serverTimezone=UTC&useSSL=false");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(conn);
	}

	public BorrowAppUsersCollection getBorrowAppUsersCollection() {
		return(buc);
	}

	private BorrowAppDatabase() {
		buc = BorrowAppUsersCollection.instance();
		Connection conn = getDb();
		try {
			readFromMySQL(conn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean readFromMySQL(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tblusers;");
			while(rs.next()) {
				String[] str = {
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("userfirstname"),
					rs.getString("userlastname"),
					Integer.toString(rs.getInt("userage")),
					rs.getString("usercontactnumber"),
					rs.getString("useremail"),
					rs.getString("role"),
					"user"
				};
				createObjectFromMySQL(str);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {if(stmt!=null) stmt.close(); } catch(Exception e) {}
			try {if(rs!=null) rs.close(); } catch(Exception e) {}
			return(result);
		}
	}

	public void createObjectFromMySQL(String... details) {
		int len = details.length-1;
		String d = details[len];
		if("user".equals(d)) {
			BorrowAppUsers b = BorrowAppUsers.instance(details[0], details[1], details[2], details[3], Integer.parseInt(details[4]), details[5], details[6], details[7]);
			buc.addUser(b);
		}
	}
}
