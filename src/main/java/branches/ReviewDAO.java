package branches;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

public class ReviewDAO {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	String user = "root"; // 또는 본인 MySQL 계정
	String password = "tiger"; // MySQL 비밀번호

	public Connection dbCon() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			if (con != null)
				System.out.println("db ok~~");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
	private void commitLetsgo() {
	      Connection con = dbCon();
	      String sql = "commit";
	      
	      try {
	         PreparedStatement pst = con.prepareStatement(sql);
	         pst.execute();
	         System.out.println("commit ok");
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	
	public ArrayList<Reviews> allReviews(String b_code){
		ArrayList<Reviews> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from REVIEWS where ID = ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, b_code);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
			    String r_code = rs.getString("R_CODE");
			    String id = rs.getString("ID");
			    String title = rs.getString("TITLE");
			    String detail = rs.getString("DETAIL");
			    Date r_date_ = rs.getDate("R_DATE");

			    if (rs.getString("ANSWER") != null) {
			        String answer = rs.getString("ANSWER");
			        list.add(new Reviews(r_code, id, title, detail, answer, r_date_));
			    } else {
			        list.add(new Reviews(r_code, id, title, detail, r_date_));
			    }
			}
			con.close();
			pst.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean InsertReview(String id, String title, String detail) {
		String rCode=UUID.randomUUID().toString().replace("-", "").substring(0, 5);
		
		Connection con = null;
		PreparedStatement pst = null;
		boolean result = false;
		String sql = "INSERT INTO reviews (R_CODE, ID, TITLE, DETAIL) "
				+ "VALUES (?,?,?,?)";
		con = dbCon();
		
		try {			
			con.setAutoCommit(false);
			
			
			pst = con.prepareStatement(sql);
			pst.setString(1, rCode);
			pst.setString(2, id);
			pst.setString(3, title);	
			pst.setString(4, detail);
			
			int rowsAffected = pst.executeUpdate();
			if(rowsAffected > 0) {
				con.commit();
				result = true;
			}
		} catch (SQLException e) {
			try{
				if(con != null) con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				if (pst != null)con.close();
				if (pst != null)pst.close();	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	public static void main(String[] args) {
		ReviewDAO a = new ReviewDAO();
		ArrayList<Reviews> list = a.allReviews("B0001");
		for(Reviews b : list) {
			System.out.println(b);
		
		}
	}
	
	
	
}
