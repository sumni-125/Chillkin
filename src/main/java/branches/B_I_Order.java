package branches;

public class B_I_Order {
	String B_I_Code;
	String B_I_Date;
	String B_Code;
	String I_Code;
	String I_Name;
	int I_Cnt;

	public B_I_Order(String b_Code, String i_Code, int i_Cnt) {
		super();
		B_Code = b_Code;
		I_Code = i_Code;
		I_Cnt = i_Cnt;
	}

	public B_I_Order(String b_I_Code, String b_I_Date, String b_Code, String i_Code, String i_Name, int i_Cnt) {
		super();
		B_I_Code = b_I_Code;
		B_I_Date = b_I_Date;
		B_Code = b_Code;
		I_Code = i_Code;
		I_Name = i_Name;
		I_Cnt = i_Cnt;
	}

	public String getB_I_Code() {
		return B_I_Code;
	}

	public String getB_I_Date() {
		return B_I_Date;
	}

	public String getB_Code() {
		return B_Code;
	}

	public String getI_Code() {
		return I_Code;
	}

	public String getI_Name() {
		return I_Name;
	}

	public int getI_Cnt() {
		return I_Cnt;
	}

	@Override
	public String toString() {
		return "B_I_Order [B_I_Code=" + B_I_Code + ", B_I_Date=" + B_I_Date + ", B_Code=" + B_Code + ", I_Code="
				+ I_Code + ", I_Name=" + I_Name + ", I_Cnt=" + I_Cnt + "]";
	}

}
