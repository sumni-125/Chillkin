package branches;

import java.sql.Date;

public class Reviews {

	String r_Code;
	String id;
	String detail;
	String answer;
	String title;
	Date r_date;

	public Reviews(String r_code, String id, String title, String detail, Date r_date) {
	    this.r_Code = r_code;
	    this.id = id;
	    this.title = title;
	    this.detail = detail;
	    this.r_date = r_date;
	}


	public Reviews(String r_Code, String id, String title, String detail, String answer, Date r_date) {
	    super();
	    this.r_Code = r_Code;
	    this.id = id;
	    this.title = title;
	    this.detail = detail;
	    this.answer = answer;
	    this.r_date = r_date;
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
		return r_date;
	}

	@Override
	public String toString() {
		return "Reviews [r_code=" + r_Code + ", id=" + id + ", title=" + title + ", detail=" + detail + ", answer="
				+ answer + "]";

	}

}
