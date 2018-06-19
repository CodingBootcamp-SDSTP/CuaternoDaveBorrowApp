import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class AllBorrowAppTransactionsServlet extends HttpServlet
{
	BorrowAppDatabase bdb;
	BorrowAppTransactionsCollection bpc;
	ArrayList<BorrowAppTransactions> transactions;

	public void init() throws ServletException {
		bdb = BorrowAppDatabase.instance();
		bpc = bdb.getBorrowAppTransactionsCollection();
		transactions = bpc.getAllBorrowAppTransactions();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<transactions>");
		for(BorrowAppTransactions b : transactions) {
			sb.append("<transaction>");
			sb.append(b.getBorrowAppTransactionsXML());
			sb.append("</transaction>");
		}
		sb.append("</transactions>");
		out.print(sb.toString());
	}

	public void destroy() {
		bdb = null;
		bpc = null;
		transactions = null;
	}
}
