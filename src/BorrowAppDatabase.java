import java.sql.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
	private BorrowAppProductsCollection bpc;
	private BorrowAppTransactionsCollection btc;
	private BorrowAppRatingsCollection brc;

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

	public BorrowAppProductsCollection getBorrowAppProductsCollection() {
		return(bpc);
	}

	public BorrowAppTransactionsCollection getBorrowAppTransactionsCollection() {
		return(btc);
	}

	public BorrowAppRatingsCollection getBorrowAppRatingsCollection() {
		return(brc);
	}

	private BorrowAppDatabase() {
		buc = BorrowAppUsersCollection.instance();
		bpc = BorrowAppProductsCollection.instance();
		btc = BorrowAppTransactionsCollection.instance();
		brc = BorrowAppRatingsCollection.instance();
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
			rs = stmt.executeQuery("SELECT * FROM tblproducts");
			while(rs.next()) {
				String[] str = {
					Integer.toString(rs.getInt("productID")),
					rs.getString("productname"),
					rs.getString("productdescription"),
					rs.getString("productpricerate"),
					rs.getBigDecimal("productprice").toString(),
					Integer.toString(rs.getInt("productquantity")),
					rs.getString("productstatus"),
					rs.getString("producttag"),
					rs.getString("owner"),
					"product"
				};
				createObjectFromMySQL(str);
			}
			rs = stmt.executeQuery("SELECT * FROM tbltransactions;");
			while(rs.next()) {
				String[] str = {
					rs.getString("transactionID"),
					rs.getString("quantityofproducts"),
					rs.getString("prodID"),
					rs.getString("pickupdate"),
					rs.getString("returndate"),
					"transaction"
				};
				createObjectFromMySQL(str);
			}
			rs = stmt.executeQuery("SELECT * FROM tblratings");
			while(rs.next()) {
				String[] str = {
					rs.getString("ratingtype"),
					Integer.toString(rs.getInt("ratingID")),
					Integer.toString(rs.getInt("rating")),
					rs.getString("review"),
					rs.getString("evaluatorID"),
					Integer.toString(rs.getInt("evaluatedprodID")),
					rs.getString("evaluateduserID"),
					Integer.toString(rs.getInt("vote")),
					"rating"
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
		switch(d) {
			case "user": {
				BorrowAppUsers b = new BorrowAppUsers.BorrowAppUsersBuilder().username(details[0]).password(details[1]).firstName(details[2]).lastName(details[3]).age(Integer.parseInt(details[4])).contact(details[5]).email(details[6]).role(details[7]).build();
				buc.addBorrowAppUser(b);
				break;
			}
			case "product": {
				if("per hour".equalsIgnoreCase(details[3])) {
					ProductRatePerHour prh = ProductRatePerHour.instance(Integer.parseInt(details[0]), details[1], details[2], details[3], new BigDecimal(details[4]), Integer.parseInt(details[5]), details[6], details[7], details[8]);
					bpc.addBorrowAppProduct(prh);
				}
				else if("per day".equalsIgnoreCase(details[3])) {
					ProductRatePerDay prd = ProductRatePerDay.instance(Integer.parseInt(details[0]), details[1], details[2], details[3], new BigDecimal(details[4]), Integer.parseInt(details[5]), details[6], details[7], details[8]);
					bpc.addBorrowAppProduct(prd);
				}
				break;
			}
			case "transaction": {
				BorrowAppTransactions bt = new BorrowAppTransactions.BorrowAppTransactionsBuilder().transactionId(Integer.parseInt(details[0])).quantity(Integer.parseInt(details[1])).productId(Integer.parseInt(details[2])).pickUpDate(LocalDate.parse(details[3])).returnDate(LocalDate.parse(details[4])).build();
				btc.addBorrowAppTransaction(bt);
				break;
			}
			case "rating": {
				if("product".equalsIgnoreCase(details[0])) {
					ProductRatings pr = ProductRatings.instance(Integer.parseInt(details[1]), Integer.parseInt(details[2]), details[3], details[4], details[5], Integer.parseInt(details[7]));
					brc.addBorrowAppRatings(pr);
				}
				else if("user".equalsIgnoreCase(details[0])) {
					UserRatings ur = UserRatings.instance(Integer.parseInt(details[1]), Integer.parseInt(details[2]), details[3], details[4], details[6], Integer.parseInt(details[7]));
					brc.addBorrowAppRatings(ur);
				}
				break;
			}
		}
	}
}
