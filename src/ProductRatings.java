public class ProductRatings extends BorrowAppRatings
{
	static ProductRatings _instance = null;

	public static ProductRatings instance(int i, int r, String rvw, String e, String ed, int v) {
		if(_instance == null) {
			_instance = new ProductRatings(i, r, rvw, e, ed, v);
		}
		return(_instance);
	}

	private String evaluatedProduct;

	private ProductRatings(int i, int r, String rvw, String e, String ed, int v) {
		setId(i);
		setRating(r);
		setReview(rvw);
		setEvaluator(e);
		evaluatedProduct = ed;
		setVote(v);
	}

	public void setEvaluatedProduct(String e) {
		evaluatedProduct = e;
	}

	public String getEvaluatedProduct() {
		return(evaluatedProduct);
	}

	@Override
	public String getBorrowAppRatingsXML() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getBorrowAppRatingsXML());
		sb.append("<evaluatedproduct>" + getEvaluatedProduct() + "</evaluatedproduct>");
		return(sb.toString());
	}
}
