public class UserRatings extends BorrowAppRatings
{
	static UserRatings _instance = null;

	public static UserRatings instance(int i, int r, String rvw, String e, String ed, int v) {
		if(_instance == null) {
			_instance = new UserRatings(i, r, rvw, e, ed, v);
		}
		return(_instance);
	}

	private String evaluatedUser;

	private UserRatings(int i, int r, String rvw, String e, String ed, int v) {
		setId(i);
		setRating(r);
		setReview(rvw);
		setEvaluator(e);
		evaluatedUser = ed;
		setVote(v);
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
		sb.append(super.getBorrowAppRatingsXML());
		sb.append("<evaluateduser>" + getEvaluatedUser() + "</evaluateduser>");
		return(sb.toString());
	}
}
