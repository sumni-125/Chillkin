package headquerter;

public class Branches {
	String branch_id;
	String pw;
	String address;
	String tel;
	
	public Branches(String branch_id, String pw, String address, String tel) {
		this.branch_id = branch_id;
		this.pw = pw;
		this.address = address;
		this.tel = tel;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public String getPw() {
		return pw;
	}

	public String getAddress() {
		return address;
	}

	public String getTel() {
		return tel;
	}

	@Override
	public String toString() {
		return "가맹점 정보 [가맹점 ID:" + branch_id + ", 비밀번호:" + pw + ", 주소:" + address + ", 전화번호:" + tel + "]\n";
	}	
}
