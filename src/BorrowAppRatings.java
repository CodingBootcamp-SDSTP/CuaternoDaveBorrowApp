public class BorrowAppRatings
{
	private int id;
	private int rating;
	private String review;
	private String evaluator;
	private int vote;

	public void setId(int i) {
		id = i;
	}

	public int getId() {
		return(id);
	}

	public void setRating(int r) {
		rating = r;
	}

	public int getRating() {
		return(rating);
	}

	public void setReview(String r) {
		review = r;
	}

	public String getReview() {
		return(review);
	}

	public void setEvaluator(String r) {
		evaluator = r;
	}

	public String getEvaluator() {
		return(evaluator);
	}

	public void setVote(int v) {
		vote = v;
	}

	public int getVote() {
		return(vote);
	}

	public String getBorrowAppRatingsXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<ratingid>" + getId() + "</ratingid>");
		sb.append("<vote>" + getVote() + "</vote>");
		sb.append("<rating>" + getRating() + "</rating>");
		sb.append("<review>" + getReview() + "</review>");
		sb.append("<evaluator>" + getEvaluator() + "</evaluator>");
		return(sb.toString());
	}
}