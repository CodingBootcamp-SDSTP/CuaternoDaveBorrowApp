import java.math.BigDecimal;

public class ProductRatePerDay extends BorrowAppProducts
{
	private String ratePerDay;

	public ProductRatePerDay(int i, String n, String d, String r, BigDecimal p, int q, String s, String t, String o) {
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
		sb.append("<perday>");
		sb.append("<pricerate>" + getRatePerDay() + "</pricerate>");
		sb.append(super.getBorrowAppProductsXML());
		sb.append("/<perday>");
		return(sb.toString());
	}
}
