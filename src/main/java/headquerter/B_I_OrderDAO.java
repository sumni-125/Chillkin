package headquerter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class B_I_OrderDAO {
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
	
	public ArrayList<B_I_Order> allOrders(){
		commitLetsfo();
		ArrayList<B_I_Order> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from B_I_ORDER order by B_I_CODE";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String b_i_code = rs.getString("B_I_CODE");
				String b_i_date = rs.getString("B_I_DATE");
				String b_code = rs.getString("B_CODE");
				String i_code = rs.getString("I_CODE");
				String cnt_ = rs.getString("I_CNT");
				int cnt = Integer.parseInt(cnt_); 
				
				list.add(new B_I_Order(b_i_code, b_i_date, b_code,i_code,cnt)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//지점별로 발주정보 조회하기
	public ArrayList<B_I_Order> groupByBranches() {
		ArrayList<B_I_Order> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "SELECT * FROM B_I_ORDER b ORDER BY b.B_CODE";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String b_i_code = rs.getString("B_I_CODE");
				String b_i_date = rs.getString("B_I_DATE");
				String b_code = rs.getString("B_CODE");
				String i_code = rs.getString("I_CODE");
				String cnt_ = rs.getString("I_CNT");
				int cnt = Integer.parseInt(cnt_); 
				
				list.add(new B_I_Order(b_i_code, b_i_date,b_code,i_code,cnt)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<B_I_Order> selectSpecificBranch(String id){
		commitLetsfo();
		ArrayList<B_I_Order> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "SELECT * FROM B_I_ORDER where B_CODE = ? ";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String b_i_code = rs.getString("B_I_CODE");
				String b_i_date = rs.getString("B_I_DATE");
				String b_code = rs.getString("B_CODE");
				String i_code = rs.getString("I_CODE");
				String cnt_ = rs.getString("I_CNT");
				int cnt = Integer.parseInt(cnt_);
				
				list.add(new B_I_Order(b_i_code, b_i_date, b_code,i_code,cnt));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	private void commitLetsfo() {
		Connection con = dbCon();
		String sql = "commit";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		B_I_OrderDAO b = new B_I_OrderDAO();
		ArrayList<B_I_Order> list1 = b.allOrders();
		ArrayList<B_I_Order> list2 = b.selectSpecificBranch("B0002");
		for(B_I_Order a : list2) {
			System.out.println(a);
		}
	}
}
