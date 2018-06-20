import java.math.BigDecimal;

public class ProductRatePerHour extends BorrowAppProducts
{
	static ProductRatePerHour _instance = null;

	public static ProductRatePerHour instance(int i, String n, String d, String r, BigDecimal p, int q, String s, String t, String o) {
		if(_instance == null) {
			_instance = new ProductRatePerHour(i, n, d, r, p, q, s, t, o);
		}
		return(_instance);
	}

	private String ratePerHour;

	public ProductRatePerHour(int i, String n, String d, String r, BigDecimal p, int q, String s, String t, String o) {
		setId(i);
		setName(n);
		setDesc(d);
		ratePerHour = r;
		setPrice(p);
		setQuantity(q);
		setStatus(s);
		setTag(t);
		setOwner(o);
	}

	public void setRatePerHour(String r) {
		ratePerHour = r;
	}

	public String getRatePerHour() {
		return(ratePerHour);
	}

	@Override
	public String getBorrowAppProductsXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<pricerate>" + getRatePerHour() + "</pricerate>");
		sb.append(super.getBorrowAppProductsXML());
		return(sb.toString());
	}
}
