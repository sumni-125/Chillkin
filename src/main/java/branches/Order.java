package branches;

public class Order {
	String O_Code;
	String Menu_Code;
	String menu_name;
	String Branch_Id;
	int O_cnt;
	String O_Date;
	
	
	
	public Order(String o_Code, String menu_name, int o_cnt, String o_Date) {
		super();
		O_Code = o_Code;
		this.menu_name = menu_name;
		O_cnt = o_cnt;
		O_Date = o_Date;
	}

	public Order(String o_Code, String menu_Code, String branch_Id, int o_cnt, String o_Date) {
		super();
		O_Code = o_Code;
		Menu_Code = menu_Code;
		Branch_Id = branch_Id;
		O_cnt = o_cnt;
		O_Date = o_Date;
	}

	public String getO_Code() {
		return O_Code;
	}

	public String getMenu_Code() {
		return Menu_Code;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public String getBranch_Id() {
		return Branch_Id;
	}

	public int getO_cnt() {
		return O_cnt;
	}

	public String getO_Date() {
		return O_Date;
	}

	@Override
	public String toString() {
		return "Order [O_Code=" + O_Code + ", Menu_Code=" + Menu_Code + ", menu_name=" + menu_name + ", Branch_Id="
				+ Branch_Id + ", O_cnt=" + O_cnt + ", O_Date=" + O_Date + "]";
	}

	
	
}
