package headquerter;

public class B_I_Order {
	String b_i_code;
	String b_i_date;
	String b_code;
	String i_code;
	int cnt;
	
	public B_I_Order(String b_i_code, String b_i_date, String b_code, String i_code, int cnt) {
		super();
		this.b_i_code = b_i_code;
		this.b_i_date = b_i_date;
		this.b_code = b_code;
		this.i_code = i_code;
		this.cnt = cnt;
	}

	public String getB_i_code() {
		return b_i_code;
	}

	public String getB_i_date() {
		return b_i_date;
	}

	public String getB_code() {
		return b_code;
	}

	public String getI_code() {
		return i_code;
	}

	public int getCnt() {
		return cnt;
	}

	@Override
	public String toString() {
		return "B_I_Order [b_i_code=" + b_i_code + ", b_i_date=" + b_i_date + ", b_code=" + b_code + ", i_code="
				+ i_code + ", cnt=" + cnt + "]";
	}
	
	
	
	
	
}
