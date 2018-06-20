import java.math.BigDecimal;

public class BorrowAppProducts
{
	private int id;
	private String name;
	private String desc;
	private BigDecimal price;
	private int quantity;
	private String status;
	private String tag;
	private String owner;

	public void setId(int i) {
		id = i;
	}

	public int getId() {
		return(id);
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return(name);
	}

	public void setDesc(String d) {
		desc = d;
	}

	public String getDesc() {
		return(desc);
	}

	public void setPrice(BigDecimal p) {
		price = p;
	}

	public BigDecimal getPrice() {
		return(price);
	}

	public void setQuantity(int q) {
		quantity = q;
	}

	public int getQuantity() {
		return(quantity);
	}

	public void setStatus(String s) {
		status = s;
	}

	public String getStatus() {
		return(status);
	}

	public void setTag(String t) {
		tag = t;
	}

	public String getTag() {
		return(tag);
	}

	public void setOwner(String o) {
		owner = o;
	}

	public String getOwner() {
		return(owner);
	}

	public String getBorrowAppProductsXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<id>" + getId() + "</id>");
		sb.append("<name>" + getName() + "</name>");
		sb.append("<description>" + getDesc() + "</description>");
		sb.append("<price>" + getPrice() + "</price>");
		sb.append("<quantity>" + getQuantity() + "</quantity>");
		sb.append("<status>" + getStatus() + "</status>");
		sb.append("<tag>" + getTag() + "</tag>");
		sb.append("<owner>" + getOwner() + "</owner>");
		return(sb.toString());
	}
}
