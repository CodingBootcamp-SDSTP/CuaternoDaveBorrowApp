import java.math.BigDecimal;

public class ProductRatePerDay extends BorrowAppProducts
{
	static ProductRatePerDay _instance = null;

	public static ProductRatePerDay instance(int i, String n, String d, String r, BigDecimal p, int q, String s, String t, String o) {
		if(_instance == null) {
			_instance = new ProductRatePerDay(i, n, d, r, p, q, s, t, o);
		}
		return(_instance);
	}

	private String ratePerDay;

	private ProductRatePerDay(int i, String n, String d, String r, BigDecimal p, int q, String s, String t, String o) {
		setId(i);
		setName(n);
		setDesc(d);
		ratePerDay = r;
		setPrice(p);
		setQuantity(q);
		setStatus(s);
		setTag(t);
		setOwner(o);
	}

	public void setRatePerDay(String r) {
		ratePerDay = r;
	}

	public String getRatePerDay() {
		return(ratePerDay);
	}

	@Override
	public String getBorrowAppProductsXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<pricerate>" + getRatePerDay() + "</pricerate>");
		sb.append(super.getBorrowAppProductsXML());
		return(sb.toString());
	}
}
