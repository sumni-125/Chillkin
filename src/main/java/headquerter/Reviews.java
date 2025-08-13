package headquerter;

import java.sql.Date;

public class Reviews {

	String r_Code;
	String id;
	String detail;
	String answer;
	String title;
	Date r_Date;
	
	
	public Reviews(String r_Code, String id, String title, String detail, String answer, Date r_Date) {
		super();
		this.r_Code = r_Code;
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.answer = answer;
		this.r_Date = r_Date;
	}
	public Reviews() {
		
	}


	public String getR_code() {
		return r_Code;
	}

	public String getId() {
		return id;
	}


	public String getDetail() {
		return detail;
	}


	public String getAnswer() {
		return answer;
	}


	public String getTitle() {
		return title;
	}
	
	public Date getR_date() {
		return r_Date;
	}

	public void setR_Code(String r_Code) {
		this.r_Code = r_Code;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setR_Date(Date r_Date) {
		this.r_Date = r_Date;
	}
	

	@Override
	public String toString() {
		return "Reviews [r_Code=" + r_Code + ", id=" + id + ", detail=" + detail + ", answer=" + answer + ", title="
				+ title + ", r_Date=" + r_Date + "]";
	}


	

	
	
	
}
