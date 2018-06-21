import java.time.LocalDate;

public class BorrowAppOrders
{
	public static class BorrowAppOrdersBuilder
	{
		private int orderId;
		private String username;
		private int productId;
		private LocalDate pickUpDate;
		private LocalDate returnDate;
		private int hoursOfUsage;
		private int cartId;

		public BorrowAppOrdersBuilder cartId(int c) {
			cartId = c;
			return(this);
		}

		public BorrowAppOrdersBuilder hoursOfUsage(int h) {
			hoursOfUsage = h;
			return(this);
		}

		public BorrowAppOrdersBuilder orderId(int t) {
			orderId = t;
			return(this);
		}
		
		public BorrowAppOrdersBuilder username(String u) {
			username = u;
			return(this);
		}

		public BorrowAppOrdersBuilder productId(int p) {
			productId = p;
			return(this);
		}

		public BorrowAppOrdersBuilder pickUpDate(LocalDate p) {
			pickUpDate = p;
			return(this);
		}

		public BorrowAppOrdersBuilder returnDate(LocalDate r) {
			returnDate = r;
			return(this);
		}

		public BorrowAppOrders build() {
			return(new BorrowAppOrders(this));
		}

		public int getOrderId() {
			return(orderId);
		}

		public String getUsername() {
			return(username);
		}

		public int getProductId() {
			return(productId);
		}

		public LocalDate getPickUpDate() {
			return(pickUpDate);
		}

		public LocalDate getReturnDate() {
			return(returnDate);
		}

		public int getHoursOfUsage() {
			return(hoursOfUsage);
		}

		public int getCartId() {
			return(cartId);
		}
	}

	final int ORDERID;
	final String USERNAME;
	final int PRODUCTID;
	final LocalDate PICKUPDATE;
	final LocalDate RETURNDATE;
	final int HOURSOFUSAGE;
	final int CARTID;

	public BorrowAppOrders(BorrowAppOrdersBuilder b) {
		ORDERID = b.getOrderId();
		USERNAME = b.getUsername();
		PRODUCTID = b.getProductId();
		PICKUPDATE = b.getPickUpDate();
		RETURNDATE = b.getReturnDate();
		HOURSOFUSAGE = b.getHoursOfUsage();
		CARTID = b.getCartId();
	}

	public String getBorrowAppOrdersXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<orderid>" + ORDERID + "</orderid>");
		sb.append("<username>" + USERNAME + "</username>");
		sb.append("<productId>" + PRODUCTID + "</productId>");
		sb.append("<pickupdate>" + PICKUPDATE + "</pickupdate>");
		sb.append("<returndate>" + RETURNDATE + "</returndate>");
		sb.append("<hoursofusage>" + HOURSOFUSAGE + "</hoursofusage>");
		sb.append("<cartid>" + CARTID + "</cartid>");
		return(sb.toString());
	}
}
