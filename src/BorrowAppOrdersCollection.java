import java.util.ArrayList;
import java.time.LocalDate;

public class BorrowAppOrdersCollection
{
	static BorrowAppOrdersCollection _instance = null;

	public static BorrowAppOrdersCollection instance() {
		if(_instance == null) {
			_instance = new BorrowAppOrdersCollection();
		}
		return(_instance);
	}

	private ArrayList<BorrowAppOrders> orders;

	private BorrowAppOrdersCollection() {
		orders = new ArrayList<BorrowAppOrders>();
	}

	public void addBorrowAppOrder(BorrowAppOrders b) {
		orders.add(b);
	}

	public int getBorrowAppOrdersCount() {
		return(orders.size());
	}

	public BorrowAppOrders getBorrowAppOrderByIndex(int n) {
		return(orders.get(n));
	}

	public ArrayList<BorrowAppOrders> getAllBorrowAppOrders() {
		return(orders);
	}

	public ArrayList<BorrowAppOrders> search(String t) {
		ArrayList<BorrowAppOrders> bs = new ArrayList<BorrowAppOrders>();
		BorrowAppOrders b = null;
		for(int i=0; i<getBorrowAppOrdersCount(); i++) {
			b = getBorrowAppOrderByIndex(i);
			if(matches(b, t)) {
				bs.add(b);
			}
		}
		return(bs);
	}

	public boolean matches(BorrowAppOrders b, String t) {
		boolean result = false;
		String tId = Integer.toString(new BorrowAppOrders.BorrowAppOrdersBuilder().getOrderId());
		String pId = Integer.toString(new BorrowAppOrders.BorrowAppOrdersBuilder().getProductId());
		String text = t.toLowerCase();
		if(tId.contains(text) || pId.contains(text)) {
			result = true;
		}
		return(result);
	}
}
