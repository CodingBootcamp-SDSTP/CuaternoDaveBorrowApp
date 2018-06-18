import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class AllBorrowAppUsersServlet extends HttpServlet
{
	BorrowAppDatabase bdb;
	BorrowAppUsersCollection bc;
	ArrayList<BorrowAppUsers> users;

	public void init() throws ServletException {
		bdb = BorrowAppDatabase.instance();
		bc = bdb.getBorrowAppUsersCollection();
		users = bc.getAllUsers();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		StringBuilder sb = new StringBuilder();
		sb.append("<users>");
		for(BorrowAppUsers b : users) {
			sb.append("<user>");
			sb.append(b.getBorrowAppUsersXML());
			sb.append("</user>");
		}
		sb.append("</users>");
		out.print(sb.toString());
	}

	public void destroy() {
		bdb = null;
		bc = null;
		users = null;
	}
}