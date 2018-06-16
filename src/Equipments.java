public class Equipments
{
	static Equipments _instance = null;

	public static Equipments instance(int id, String n, int d, String p, String s) {
		if(_instance == null) {
			_instance = new Equipments(id, n, d, p, s);
		}
		return(_instance);
	}

	private int id;
	private String name;
	private int dateRegistered;
	private String rate;
	private String status;

	private Equipments(int id, String n, int d, String p, String s) {
		this.id = id;
		name = n;
		dateRegistered = d;
		rate = p;
		status = s;
	}

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

	public void setDateRegistered(int d) {
		dateRegistered = d;
	}

	public int getDateRegistered() {
		return(dateRegistered);
	}

	public void setRate(String p) {
		rate = p;
	}

	public String getRate() {
		return(rate);
	}

	public void setStatus(String s) {
		status = s;
	}

	public String getStatus() {
		return(status);
	}
}
