import java.time.LocalDate;

public class BorrowAppTransactions
{
	public static class BorrowAppTransactionsBuilder
	{
		private int transactionId;
		private int quantity;
		private int productId;
		private LocalDate pickUpDate;
		private LocalDate returnDate;

		public BorrowAppTransactionsBuilder transactionId(int t) {
			transactionId = t;
			return(this);
		}
		
		public BorrowAppTransactionsBuilder quantity(int q) {
			quantity = q;
			return(this);
		}

		public BorrowAppTransactionsBuilder productId(int p) {
			productId = p;
			return(this);
		}

		public BorrowAppTransactionsBuilder pickUpDate(LocalDate p) {
			pickUpDate = p;
			return(this);
		}

		public BorrowAppTransactionsBuilder returnDate(LocalDate r) {
			returnDate = r;
			return(this);
		}

		public BorrowAppTransactions build() {
			return(new BorrowAppTransactions(this));
		}

		public int getTransactionId() {
			return(transactionId);
		}

		public int getQuantity() {
			return(quantity);
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
	}

	final int TRANSACTIONID;
	final int QUANTITY;
	final int PRODUCTID;
	final LocalDate PICKUPDATE;
	final LocalDate RETURNDATE;

	public BorrowAppTransactions(BorrowAppTransactionsBuilder b) {
		TRANSACTIONID = b.getTransactionId();
		QUANTITY = b.getQuantity();
		PRODUCTID = b.getProductId();
		PICKUPDATE = b.getPickUpDate();
		RETURNDATE = b.getReturnDate();
	}

	public String getBorrowAppTransactionsXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<transactionid>" + TRANSACTIONID + "</transactionid>");
		sb.append("<quantity>" + QUANTITY + "</quantity>");
		sb.append("<productId>" + PRODUCTID + "</productId>");
		sb.append("<pickupdate>" + PICKUPDATE + "</pickupdate>");
		sb.append("<returndate>" + RETURNDATE + "</returndate>");
		return(sb.toString());
	}
}
