package branches;

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

	public void insertUser(String password, String address, String tel) {
        Connection con = dbcon();
        String sql = "INSERT INTO BRANCHES (PW, ADDRESS, TEL) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, password);
            pst.setString(2, address);
            pst.setString(3, tel);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void delete(String branchId) {

		Connection con = dbcon();
		String sql = "DELETE FROM BRANCHES WHERE BRANCH_ID = ?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, branchId);
			pst.executeUpdate();

			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkLogin(String branchId, String pw) {
		Connection con = dbcon();
		String sql = "SELECT * FROM BRANCHES WHERE BRANCH_ID = ? AND PW = ?";
		boolean result = false;

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, branchId);
			pst.setString(2, pw);

			ResultSet rs = pst.executeQuery();

			result = rs.next();

			rs.close();
			pst.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getAddressByBranchId(String branchId) {
	    String address = null;
	    Connection con = dbcon();
	    String sql = "SELECT ADDRESS FROM BRANCHES WHERE BRANCH_ID = ?";

	    try {
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, branchId);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            address = rs.getString("ADDRESS");
	        }

	        rs.close();
	        pst.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return address;
	}

	public ArrayList<Branches> selectBranches() {
		Connection con = dbcon();
		PreparedStatement pst = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM BRANCHES WHERE SUBSTRING(BRANCH_ID, 1, 1) = 'B'";
		ArrayList<Branches> list = new ArrayList<>();

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
                String branchId = rs.getString("BRANCH_ID");
                String pw = rs.getString("PW");
                String address = rs.getString("ADDRESS");
                String tel = rs.getString("TEL");

                Branches b = new Branches(branchId, pw, address, tel);
                list.add(b);
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

	public static void main(String[] args) {
		BranchesDAO b = new BranchesDAO();
		System.out.println(b.selectBranches());
	}

}
