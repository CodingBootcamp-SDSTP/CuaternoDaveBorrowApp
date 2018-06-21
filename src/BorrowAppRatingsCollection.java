import java.util.ArrayList;

public class BorrowAppRatingsCollection
{
	static BorrowAppRatingsCollection _instance = null;

	public static BorrowAppRatingsCollection instance() {
		if(_instance == null) {
			_instance = new BorrowAppRatingsCollection();
		}
		return(_instance);
	}

	private ArrayList<BorrowAppRatings> ratings;

	private BorrowAppRatingsCollection() {
		ratings = new ArrayList<BorrowAppRatings>();
	}

	public void addBorrowAppRatings(BorrowAppRatings b) {
		ratings.add(b);
	}

	public int getBorrowAppRatingsCount() {
		return(ratings.size());
	}

	public BorrowAppRatings getBorrowAppRatingsByIndex(int n) {
		return(ratings.get(n));
	}

	public ArrayList<BorrowAppRatings> getAllBorrowAppRatings() {
		return(ratings);
	}

	public ArrayList<BorrowAppRatings> search(String t) {
		ArrayList<BorrowAppRatings> rts = new ArrayList<BorrowAppRatings>();
		BorrowAppRatings b = null;
		for(int i=0; i<getBorrowAppRatingsCount(); i++) {
			b = getBorrowAppRatingsByIndex(i);
			if(matches(b, t)) {
				rts.add(b);
			}
		}
		return(rts);
	}

	public boolean matches(BorrowAppRatings b, String t) {
		boolean result = false;
		String rating = Integer.toString(b.getRating()).toLowerCase();
		String evaluator = b.getEvaluator().toLowerCase();
		String type = b.getType().toLowerCase();
		String txt = t.toLowerCase();
		if(rating.equals(txt) || evaluator.equals(txt) || type.contains(txt)) {
			result = true;
		}
		return(result);
	}
}