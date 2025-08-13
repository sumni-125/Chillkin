package branches;

public class Ingredients {
	
	String i_code;
	String branch_id;
	String i_name;
	int i_cnt;
	
	
	public Ingredients(String i_code, String branch_id, String i_name, int i_cnt) {
		this.i_code = i_code;
		this.branch_id = branch_id;
		this.i_name = i_name;
		this.i_cnt = i_cnt;
	}


	public String getI_code() {
		return i_code;
	}


	public void setI_code(String i_code) {
		this.i_code = i_code;
	}


	public String getBranch_id() {
		return branch_id;
	}


	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}


	public String getI_name() {
		return i_name;
	}


	public void setI_name(String i_name) {
		this.i_name = i_name;
	}


	public int getI_cnt() {
		return i_cnt;
	}


	public void setI_cnt(int i_cnt) {
		this.i_cnt = i_cnt;
	}


	@Override
	public String toString() {
		return "Ingredients [i_code=" + i_code + ", branch_id=" + branch_id + ", i_name=" + i_name + ", i_cnt=" + i_cnt
				+ "]";
	}
	
	
}
