package headquerter;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReviewService {
	ReviewDAO dao = new ReviewDAO();
	
	public ArrayList<Reviews> getReviewList(){		
		return dao.allReviews();
	}
	
	public JSONArray getJsonArray() {
		ArrayList<Reviews> list = dao.allReviews();
		JSONArray arr = new JSONArray();
		
		System.out.println(list.size());
		
		for( int i=0; i<list.size() ;i++) {	
			Reviews review = list.get(i);
			 System.out.println("r_code: " + review.getR_code()
             + ", title: " + review.getTitle()
             + ", detail: " + review.getDetail()
             + ", answer: " + review.getAnswer()
             + ", r_date: " + review.getR_date());
			JSONObject o = new JSONObject();
			o.put("R_CODE", review.getR_code());
			o.put("ID", review.getId());
			o.put("Title", review.getTitle());
			o.put("Detail", review.getDetail());
			if(review.getAnswer()!=null) {
				o.put("Answer", review.getAnswer());
			}else {
				review.answer=null;
			}
			o.put("R_DATE",review.getR_date());
			arr.put(o);
		}
		return arr;
	}
	
	public void doAnswer(String r_code, String H_answer) {
		dao.writeAnswer(r_code,H_answer);
	}
	
	public PagingVO getPaging(int page) {
		PagingVO paging = new PagingVO();
		paging.setCurPage(page);
		paging.setTotalRowCount(dao.getTotalCount());
		paging.pageSetting();
		return paging;
	}
	
	public List<Reviews> getPagedReviews(PagingVO paging){
		ReviewDAO dao = new ReviewDAO();
		List<Reviews> list = dao.getPagedList(paging);
		System.out.println("리스트 크기: " + list.size());
		return dao.getPagedList(paging);
	}
	
	
	public static void main(String[] args) {
		ReviewService service = new ReviewService();
		System.out.println(service.getJsonArray());
	}
}
