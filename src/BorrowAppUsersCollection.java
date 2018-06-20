import java.util.ArrayList;

public class BorrowAppUsersCollection
{
	static BorrowAppUsersCollection _instance = null;

	public static BorrowAppUsersCollection instance() {
		if(_instance == null) {
			_instance = new BorrowAppUsersCollection();
		}
		return _instance;
	}

	private ArrayList<BorrowAppUsers> users;

	private BorrowAppUsersCollection() {
		users = new ArrayList<BorrowAppUsers>();
	}

	public void addBorrowAppUser(BorrowAppUsers b) {
		users.add(b);
	}

	public BorrowAppUsers getBorrowAppUserByIndex(int n) {
		return(users.get(n));
	}

	public ArrayList<BorrowAppUsers> getAllBorrowAppUsers() {
		return(users);
	}

	public int getBorrowAppUsersCount() {
		return(users.size());
	}

	public ArrayList<BorrowAppUsers> searchByUsername(String s) {
		ArrayList<BorrowAppUsers> bau = new ArrayList<BorrowAppUsers>();
		BorrowAppUsers b = null;
		String txt = s.toLowerCase();
		for(int i=0; i<getBorrowAppUsersCount(); i++) {
			b = getBorrowAppUserByIndex(i);
			if(matches(b, txt)) {
				bau.add(b);
			}
		}
		return(bau);
	}

	public boolean matches(BorrowAppUsers b, String s) {
		boolean result = false;
		String un = b.USERNAME.toLowerCase();
		String txt = s.toLowerCase();
		if(un.contains(txt)) {
			result = true;
		}
		return(result);
	}
}
