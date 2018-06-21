public class ProductRatings extends BorrowAppRatings
{
	private String evaluatedProduct;

	public ProductRatings(int i, int r, String rvw, String e, String ed, int v, String t) {
		setId(i);
		setRating(r);
		setReview(rvw);
		setEvaluator(e);
		evaluatedProduct = ed;
		setVote(v);
		setType(t);
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
		sb.append("<productrating>");
		sb.append(super.getBorrowAppRatingsXML());
		sb.append("<evaluatedproduct>" + getEvaluatedProduct() + "</evaluatedproduct>");
		sb.append("</productrating>");
		return(sb.toString());
	}
}
