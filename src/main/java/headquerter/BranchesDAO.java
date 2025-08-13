package headquerter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BranchesDAO {
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
	
	public ArrayList<Branches> allBranches(){
		ArrayList<Branches> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from BRANCHES where substr(BRANCH_ID,1,1) = 'B'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("BRANCH_ID");
				String pw = rs.getString("PW");
				String addr = rs.getString("ADDRESS");
				String tel = rs.getString("TEL");				
				
				list.add(new Branches(id,pw,addr,tel)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public ArrayList<Branches> allBranchesnh(){
		ArrayList<Branches> list = new ArrayList<>();
		Connection con = dbCon();
		String sql = "select * from BRANCHES where substr(BRANCH_ID,1,1) = 'B'";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("BRANCH_ID");
				String pw = rs.getString("PW");
				String addr = rs.getString("ADDRESS");
				String tel = rs.getString("TEL");					
				
				list.add(new Branches(id,pw,addr,tel)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		BranchesDAO b = new BranchesDAO();
		ArrayList<Branches> list = b.allBranchesnh();
		for(Branches a : list) {
			System.out.println(a);
		}
	}
}
