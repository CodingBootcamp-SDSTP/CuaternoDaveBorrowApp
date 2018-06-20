import java.util.ArrayList;

public class BorrowAppProductsCollection
{
	static BorrowAppProductsCollection _instance = null;

	public static BorrowAppProductsCollection instance() {
		if(_instance == null) {
			_instance = new BorrowAppProductsCollection();
		}
		return(_instance);
	}

	ArrayList<BorrowAppProducts> products;

	private BorrowAppProductsCollection() {
		products = new ArrayList<BorrowAppProducts>();
	}

	public void addBorrowAppProduct(BorrowAppProducts b) {
		products.add(b);
	}

	public BorrowAppProducts getBorrowAppProductByIndex(int n) {
		return(products.get(n));
	}

	public int getBorrowAppProductsCount() {
		return(products.size());
	}

	public ArrayList<BorrowAppProducts> getAllBorrowAppProducts() {
		return(products);
	}

	public ArrayList<BorrowAppProducts> search(String s) {
		BorrowAppProducts b = null;
		ArrayList<BorrowAppProducts> prods = new ArrayList<BorrowAppProducts>();
		for(int i=0; i<getBorrowAppProductsCount(); i++) {
			b = getBorrowAppProductByIndex(i);
			if(matches(b, s)) {
				prods.add(b);
			}
		}
		return(prods);
	}

	public boolean matches(BorrowAppProducts p, String s) {
		boolean result = false;
		String id = Integer.toString(p.getId()).toLowerCase();
		String name = p.getName().toLowerCase();
		String price = p.getPrice().toString().toLowerCase();
		String quantity = Integer.toString(p.getQuantity()).toLowerCase();
		String status = p.getStatus().toLowerCase();
		String tag = p.getTag().toLowerCase();
		String owner = p.getOwner().toLowerCase();
		String txt = s.toLowerCase();
		if(id.contains(txt) || name.contains(txt) || price.contains(txt) || quantity.contains(txt) || status.contains(txt) || tag.contains(txt) || owner.contains(txt)) {
			result = true;
		}
		return(result);
	}
}
