package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDAO {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	String user = "root"; // 또는 본인 MySQL 계정
	String password = "tiger"; // MySQL 비밀번호

	public Connection dbcon() {

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
	
	public ArrayList<Menu> selectAll(){
		
		ArrayList<Menu> list = new ArrayList<Menu>();
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql="select * from MENU";
		
		try {
			
			pst = con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				String Menu_Code = rs.getString("MENU_CODE");
				String Menu_Name = rs.getString("MENU_NAME");
				String Price = rs.getString("PRICE");
				String ingredient_needs = rs.getString("INGREDIENT_NEEDS");
				
				Menu m = new Menu(Menu_Code, Menu_Name, Price, ingredient_needs);
				list.add(m);
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
	
	public Menu selectOne(String menu_code) {
		
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String sql="select * from MENU where MENU_CODE=?";
		Menu m =null;
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,menu_code);
			
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				
				String Menu_Code = rs.getString("MENU_CODE");
				String Menu_Name = rs.getString("MENU_NAME");
				String Price = rs.getString("PRICE");
				String ingredient_needs = rs.getString("INGREDIENT_NEEDS");
				
				m= new Menu(Menu_Code, Menu_Name, Price, ingredient_needs);
			}
			
			con.close();
			pst.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return m;
	}
	
}
