import java.util.ArrayList;
import java.time.LocalDate;

public class BorrowAppTransactionsCollection
{
	static BorrowAppTransactionsCollection _instance = null;

	public static BorrowAppTransactionsCollection instance() {
		if(_instance == null) {
			_instance = new BorrowAppTransactionsCollection();
		}
		return(_instance);
	}

	private ArrayList<BorrowAppTransactions> transactions;

	private BorrowAppTransactionsCollection() {
		transactions = new ArrayList<BorrowAppTransactions>();
	}

	public void addBorrowAppTransaction(BorrowAppTransactions b) {
		transactions.add(b);
	}

	public int getBorrowAppTransactionsCount() {
		return(transactions.size());
	}

	public BorrowAppTransactions getBorrowAppTransactionByIndex(int n) {
		return(transactions.get(n));
	}

	public ArrayList<BorrowAppTransactions> getAllBorrowAppTransactions() {
		return(transactions);
	}

	public ArrayList<BorrowAppTransactions> search(String t) {
		ArrayList<BorrowAppTransactions> bs = new ArrayList<BorrowAppTransactions>();
		BorrowAppTransactions b = null;
		for(int i=0; i<getBorrowAppTransactionsCount(); i++) {
			b = getBorrowAppTransactionByIndex(i);
			if(matches(b, t)) {
				bs.add(b);
			}
		}
		return(bs);
	}

	public boolean matches(BorrowAppTransactions b, String t) {
		boolean result = false;
		String tId = Integer.toString(new BorrowAppTransactions.BorrowAppTransactionsBuilder().getTransactionId());
		String pId = Integer.toString(new BorrowAppTransactions.BorrowAppTransactionsBuilder().getProductId());
		String text = t.toLowerCase();
		if(tId.contains(text) || pId.contains(text)) {
			result = true;
		}
		return(result);
	}
}
