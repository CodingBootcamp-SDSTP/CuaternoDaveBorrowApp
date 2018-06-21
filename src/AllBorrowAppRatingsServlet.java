import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class AllBorrowAppRatingsServlet extends HttpServlet
{
	BorrowAppDatabase bdb;
	BorrowAppRatingsCollection bac;
	ArrayList<BorrowAppRatings> ratings;

	public void init() throws ServletException {
		bdb = BorrowAppDatabase.instance();
		bac = bdb.getBorrowAppRatingsCollection();
		ratings = bac.getAllBorrowAppRatings();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		String qString = request.getQueryString();
		if(qString == null) {
			out.print(getAllRatings(ratings));
		}
		else {
			String[] qSplit = qString.split("=");
			out.print(getRatingsByQueryString(bac, qSplit));
		}
	}

	public String getRatingsByQueryString(BorrowAppRatingsCollection ratings, String... q) {
		StringBuilder sb = new StringBuilder();
		ArrayList<BorrowAppRatings> r = ratings.search(q[1]);
		sb.append("<ratings>");
		if("rating".equals(q[0])) {
			for (BorrowAppRatings b : r) {
				if(b instanceof UserRatings) {
					sb.append(b.getBorrowAppRatingsXML());
				}
			}
		}
		sb.append("</ratings>");
		return(sb.toString());
	}

	public String getRatingsXML(ArrayList<BorrowAppRatings> ratings) {
		StringBuilder sb = new StringBuilder();
		for(BorrowAppRatings b : ratings) {
			if(b instanceof UserRatings) {
				UserRatings r = (UserRatings)b;
				sb.append(r.getBorrowAppRatingsXML());
			}
			else if(b instanceof ProductRatings) {
				ProductRatings pr = (ProductRatings)b;
				sb.append(pr.getBorrowAppRatingsXML());
			}
		}
		return(sb.toString());
	}

	public String getAllRatings(ArrayList<BorrowAppRatings> ratings) {
		StringBuilder sb = new StringBuilder();
		sb.append("<ratings>");
		sb.append(getRatingsXML(ratings));
		sb.append("</ratings>");
		return(sb.toString());
	}

	public void destroy() {
		bdb = null;
		bac = null;
		ratings = null;
	}
}
