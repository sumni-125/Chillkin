package branches;

public class Branches {
	
	String Branch_Id;
	String Pw;
	String Address;
	String Tel;
	
	
	public Branches(String branch_Id, String pw, String address, String tel) {
		super();
		Branch_Id = branch_Id;
		Pw = pw;
		Address = address;
		Tel = tel;
	}


	public String getBranch_Id() {
		return Branch_Id;
	}


	public String getPw() {
		return Pw;
	}


	public String getAddress() {
		return Address;
	}


	public String getTel() {
		return Tel;
	}


	@Override
	public String toString() {
		return "Branches [Branch_Id=" + Branch_Id + ", Pw=" + Pw + ", Address=" + Address + ", Tel=" + Tel + "]";
	}
	
	
	
	
}
