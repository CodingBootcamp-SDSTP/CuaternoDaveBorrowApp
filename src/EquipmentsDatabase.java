import java.util.ArrayList;
import java.sql.*;

public class EquipmentsDatabase
{
	static EquipmentsDatabase _instance = null;

	public static EquipmentsDatabase instance() {
		if(_instance == null) {
			_instance = new EquipmentsDatabase();
		}
		return(_instance);
	}

	private EquipmentsDatabase() {
		Connection conn = null;
		try {
			conn = getDb();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		readFromSQL(conn);
	}

	public boolean readFromSQL(Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tbl_equipments;");
			while(rs.next()) {
				String[] str = {
					Integer.toString(rs.getInt("eq_ID")),
					rs.getString("eq_name"),
					Integer.toString(rs.getInt("date_registered")),
					rs.getString("res_rate"),
					rs.getString("status"),
					"equipments"
				};
				createObjectFromDatabase(str);
			}
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{if(stmt!=null) stmt.close();} catch(Exception e) {}
			try{if(rs!=null) rs.close();} catch(Exception e) {}
			return(result);
		}
	}

	public void createObjectFromDatabase(String... details) {
		int len = details.length-1;
		String d = details[len];
		if("equipments".equals(d)) {
			Equipments e = Equipments.instance(Integer.parseInt(details[0]), details[1], Integer.parseInt(details[2]), details[3], details[4]);
		}
	}

	public Connection getDb() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/db_reservation?user=rsrv_user&" + "password=rsrv&serverTimezone=UTC&useSSL=false");
			stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS IF NOT EXISTS tbl_reservees ( reservee_id INTEGER PRIMARY KEY NOT NULL, rsrv_firstname VARCHAR(255) NOT NULL, rsrv_lastname VARCHAR(255) NOT NULL, rsrv_contact_num INTEGER NOT NULL );");
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tbl_status ( status_ID VARCHAR(255) PRIMARY KEY NOT NULL, status_desc VARCHAR(255) NOT NULL );");
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tbl_equipments ( eq_ID INTEGER(255) PRIMARY KEY NOT NULL, eq_name VARCHAR(255) NOT NULL, date_registered INTEGER(255) NOT NULL, res_price_per_hour INTEGER(255) NOT NULL, status VARCHAR (255), FOREIGN KEY (status) REFERENCES tbl_status ( status_ID ) );");
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tbl_reservations ( res_ID INTEGER PRIMARY KEY NOT NULL, eq_ID INTEGER(255), date_reserved INTEGER NOT NULL, pick_up_date INTEGER NOT NULL, return_data INTEGER NOT NULL, res_desc VARCHAR(255) );");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{if(stmt!=null) stmt.close();} catch(Exception e) {e.printStackTrace();}
			return(conn);
		}
	}
}
