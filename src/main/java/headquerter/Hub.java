package headquerter;

public class Hub {
	String code;
	String name;
	int cnt;
	String price;
	
	public Hub(String code, String name, int cnt, String price) {
		this.code = code;
		this.name = name;
		this.cnt = cnt;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getCnt() {
		return cnt;
	}

	public String getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Hub [code=" + code + ", name=" + name + ", cnt=" + cnt + ", price=" + price + "]";
	}
}
