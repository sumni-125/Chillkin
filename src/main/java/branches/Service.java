package branches;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


public class Service {

	MenuDAO mdao = new MenuDAO();

	OrderDAO odao = new OrderDAO();

	BranchesDAO bdao = new BranchesDAO();
	
	HubDAO hdao = new HubDAO();
	
	B_I_OrderDAO bidao = new B_I_OrderDAO();
	
	IngredientsDAO idao = new IngredientsDAO();
	
	ReviewDAO rdao = new ReviewDAO();
	
	public String getAddressByBranchId(String branchId) {
		return bdao.getAddressByBranchId(branchId);
	}

	public ArrayList<Menu> selectMenu() {

		ArrayList<Menu> list = mdao.selectAll();

		return list;
	}

	public void insertOrder(String Menu_Code, String Branch_Id, int O_cnt) {
		odao.insertOrder(Menu_Code, Branch_Id, O_cnt);
	}
	
	public ArrayList<Order> selectOrder(String Branch_Id) {
		return odao.selectOrder(Branch_Id);
	}
	
	public ArrayList<Branches> selectBranchesList(){
		return bdao.selectBranches();
	}
	
	public ArrayList<Hub> selectHub(){
		
		return hdao.allHubs();
	}
	
	public void insertBIOrder(B_I_Order i) {
		bidao.insertIORder(i);
	}
	
	public ArrayList<B_I_Order> selectBIOrder(String B_Code){
		
		return bidao.selectOrders(B_Code);
	}
	
	public ArrayList<Ingredients> selectIngredients(String branchId){
		return idao.selectAll(branchId);
	}
	
	public boolean checkLogin(String branchId, String pw) {
		return bdao.checkLogin(branchId, pw);
	}
	
	public boolean InsertReview(String id, String title, String detail) {
		return rdao.InsertReview(id, title, detail);
	}
	
	
	public ArrayList<Reviews> getReviewList(String b_code){		
		return rdao.allReviews(b_code);
	}
	
	public JSONArray getJsonArray(String b_code) {
		ArrayList<Reviews> list = rdao.allReviews(b_code);
		JSONArray arr = new JSONArray();
		
		System.out.println(list.size());
		
		for( int i=0; i<list.size() ;i++) {	
			Reviews review = list.get(i);
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
	
	public static void main(String[] args) {
		Service s = new Service();
		System.out.println(s.getJsonArray("B2222"));
	}

}
