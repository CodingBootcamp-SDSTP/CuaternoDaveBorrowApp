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

	}

	public String getAllProductsXML(ArrayList<BorrowAppProducts> products) {
		StringBuilder sb = new StringBuilder();
		for(BorrowAppProducts b : products) {
			if(b instanceof ProductRatePerDay) {
				ProductRatePerDay p = (ProductRatePerDay)b;
				sb.append(p.getBorrowAppProductsXML());
			}
			else if(b instanceof ProductRatePerHour) {
				ProductRatePerHour pr = (ProductRatePerHour)b;
				sb.append(pr.getBorrowAppProductsXML());
			}
		}
		return(sb.toString());
	}

	public String getAllProducts(ArrayList<BorrowAppProducts> products) {
		StringBuilder sb = new StringBuilder();
		sb.append("<products>");
		sb.append(getAllProductsXML(products));
		sb.append("</products>");
		return(sb.toString());
	}

	public void destroy() {
		bdb = null;
		bpc = null;
		products = null;
	}
}
