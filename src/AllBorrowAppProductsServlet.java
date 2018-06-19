import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class AllBorrowAppProductsServlet extends HttpServlet
{
	BorrowAppDatabase bdb;
	BorrowAppProductsCollection bpc;
	ArrayList<BorrowAppProducts> products;

	public void init() throws ServletException {
		bdb = BorrowAppDatabase.instance();
		bpc = bdb.getBorrowAppProductsCollection();
		products = bpc.getAllBorrowAppProducts();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<products>");
		for(BorrowAppProducts b : products) {
			sb.append("<product>");
			sb.append(b.getBorrowAppProductsXML());
			sb.append("</product>");
		}
		sb.append("</products>");
		out.print(sb.toString());
	}

	public void destroy() {
		bdb = null;
		bpc = null;
		products = null;
	}
}
