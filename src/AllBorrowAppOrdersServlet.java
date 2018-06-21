import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class AllBorrowAppOrdersServlet extends HttpServlet
{
	BorrowAppDatabase bdb;
	BorrowAppOrdersCollection bpc;
	ArrayList<BorrowAppOrders> orders;

	public void init() throws ServletException {
		bdb = BorrowAppDatabase.instance();
		bpc = bdb.getBorrowAppOrdersCollection();
		orders = bpc.getAllBorrowAppOrders();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<orders>");
		for(BorrowAppOrders b : orders) {
			sb.append("<order>");
			sb.append(b.getBorrowAppOrdersXML());
			sb.append("</order>");
		}
		sb.append("</orders>");
		out.print(sb.toString());
	}

	public void destroy() {
		bdb = null;
		bpc = null;
		orders = null;
	}
}
