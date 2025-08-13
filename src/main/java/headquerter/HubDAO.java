package headquerter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HubDAO {
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
	
	public ArrayList<Hub> allHubs(){
		ArrayList<Hub> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from HUB";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String code = rs.getString("H_I_CODE");
				String name = rs.getString("H_I_NAME");
				String cnt_ = rs.getString("H_I_CNT");
				int cnt = Integer.parseInt(cnt_);
				String price = rs.getString("H_I_PRICE");
				
				list.add(new Hub(code,name,cnt,price)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
//	//발주정보 테이블에서 갖고오기
//	private BIOrder orderingIngredient() {
//		Connection con = dbCon();
//		String sql = "select * from b_i_order";
//		ArrayList<BIOrder> list = new ArrayList<>();
//	}
//	
//	//갖고와서 Hub테이블에서 뺴기
//	public void orderIngredient() {
//		Connection con = dbCon();
//		String sql = "update hub set ";
//	}
	
	public static void main(String[] args) {
		HubDAO a = new HubDAO();
		ArrayList<Hub> list = a.allHubs();
		for(Hub b : list) {
			System.out.println(b);
		}
	}
}
