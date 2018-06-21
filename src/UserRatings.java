public class UserRatings extends BorrowAppRatings
{
	private String evaluatedUser;

	public UserRatings(int i, int r, String rvw, String e, String ed, int v, String t) {
		setId(i);
		setRating(r);
		setReview(rvw);
		setEvaluator(e);
		evaluatedUser = ed;
		setVote(v);
		setType(t);
	}

	public void setEvaluatedUser(String e) {
		evaluatedUser = e;
	}

	public String getEvaluatedUser() {
		return(evaluatedUser);
	}

	@Override
	public String getBorrowAppRatingsXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<userrating>");
		sb.append(super.getBorrowAppRatingsXML());
		sb.append("<evaluateduser>" + getEvaluatedUser() + "</evaluateduser>");
		sb.append("</userrating>");
		return(sb.toString());
	}
}
