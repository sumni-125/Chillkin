package headquerter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	String user = "root"; // 또는 본인 MySQL 계정
	String password = "tiger"; // MySQL 비밀번호
	
	private Connection dbCon() {		
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, password);
			if( con != null) { System.out.println("db ok");}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public ArrayList<Reviews> allReviews(){
		ArrayList<Reviews> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "SELECT R_CODE, ID, TITLE, DETAIL, ANSWER, R_DATE FROM REVIEWS";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String r_code = rs.getString("R_CODE");
				String id = rs.getString("ID");
				String title = rs.getString("TITLE");
				String detail = rs.getString("DETAIL");				
				String answer = rs.getString("ANSWER");
				Date r_date = rs.getDate("R_DATE");
				
				list.add(new Reviews(r_code,id,title,detail,answer, r_date)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//얘가 지금 하던거임 04/16버전
	public void writeAnswer(String r_code, String H_answer) {
		if(r_code == null) {
			System.out.println("리뷰 코드 null");
		}
		
		Reviews thatReview = null;
		ArrayList<Reviews> list = allReviews();
		for(Reviews b : list) {
			if(r_code.equals(b.getR_code())) {
				thatReview = b;
			}
		}
		
		Connection con = dbCon();
		String sql = "UPDATE REVIEWS\r\n"
				+ "SET ANSWER = ? \r\n"
				+ "WHERE R_CODE = ? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, H_answer);
			pst.setString(2, thatReview.getR_code());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	public List<Reviews> getPagedList(PagingVO paging){
		List<Reviews> pagelist = new ArrayList<>();
		ReviewDAO dao = new ReviewDAO();
		
		String sql = "SELECT * FROM ("
				+ "    SELECT a.*, ROWNUM rn"
				+ "    FROM ("
				+ "        SELECT R_CODE, ID, TITLE, DETAIL, ANSWER, R_DATE"
				+ "        FROM REVIEWS"
				+ "        ORDER BY R_CODE ASC"
				+ "    ) AS a"
				+ "    WHERE ROWNUM <= ?"
				+ ") AS b "
				+ "WHERE rn >= ?";

		
		try (Connection con = dao.dbCon();
			 PreparedStatement pst = con.prepareStatement(sql)){
			
			pst.setInt(1, paging.getLastRow());
			pst.setInt(2, paging.getFirstRow());
			
			try(ResultSet rs = pst.executeQuery()){
				System.out.println("쿼리 실행 완료" + rs.getRow());
				while(rs.next()) {
					Reviews reviews = new Reviews();
					
					reviews.setR_Code(rs.getString("R_CODE"));
					reviews.setId(rs.getString("ID"));
					reviews.setTitle(rs.getString("TITLE"));
					reviews.setDetail(rs.getString("DETAIL"));
					reviews.setAnswer(rs.getString("ANSWER"));
					reviews.setR_Date(rs.getDate("R_DATE"));
						
					
					pagelist.add(reviews);
					System.out.println(pagelist);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리뷰 개수: " + pagelist.size());
		System.out.println("firstRow: " + paging.getFirstRow());
		System.out.println("lastRow: " + paging.getLastRow());
		return pagelist;
	}
	*/
	
	public List<Reviews> getPagedList(PagingVO paging) {
	    List<Reviews> pagelist = new ArrayList<>();

	    // 정렬 기준은 필요한 컬럼으로 바꿔도 됩니다.
	    final String sql =
	        "SELECT R_CODE, ID, TITLE, DETAIL, ANSWER, R_DATE " +
	        "FROM REVIEWS " +
	        "ORDER BY R_CODE ASC " +
	        "LIMIT ?, ?";  // offset, count

	    // firstRow는 1부터라고 가정
	    int offset = Math.max(0, paging.getFirstRow() - 1);
	    int count  = Math.max(1, paging.getLastRow() - paging.getFirstRow() + 1);

	    try (Connection con = dbCon();
	         PreparedStatement pst = con.prepareStatement(sql)) {

	        pst.setInt(1, offset);
	        pst.setInt(2, count);

	        try (ResultSet rs = pst.executeQuery()) {
	            while (rs.next()) {
	                Reviews r = new Reviews();
	                r.setR_Code(rs.getString("R_CODE"));
	                r.setId(rs.getString("ID"));
	                r.setTitle(rs.getString("TITLE"));
	                r.setDetail(rs.getString("DETAIL"));
	                r.setAnswer(rs.getString("ANSWER"));
	                r.setR_Date(rs.getDate("R_DATE"));
	                pagelist.add(r);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    System.out.println("리뷰 개수: " + pagelist.size());
	    System.out.println("firstRow: " + paging.getFirstRow());
	    System.out.println("lastRow: " + paging.getLastRow());
	    return pagelist;
	}

	
	public int getTotalCount() {
		String sql = "select Count(*) from reviews";
		ReviewDAO dao = new ReviewDAO();
		
		Connection con = dao.dbCon();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews();
		for(Reviews b : list) {
			System.out.println(b);
		}
		a.writeAnswer(null, null);
		String r_code = "R0001";
		a.writeAnswer(r_code, "dkssudgktpdy rkatkgkqsl;ek");

	}
}
