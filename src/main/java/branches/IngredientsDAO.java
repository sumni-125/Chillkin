package branches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientsDAO {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	String user = "root"; // 또는 본인 MySQL 계정
	String password = "tiger"; // MySQL 비밀번호

	private Connection getConnection() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("db ok");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

	public ArrayList<Ingredients> selectAll() {

		Connection con = getConnection();
		ArrayList<Ingredients> list = new ArrayList<>();
		String sql = "select * from INGREDIENTS";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String i_code = rs.getString("I_CODE");
				String branch_id = rs.getString("BRANCH_ID");
				String i_name = rs.getString("I_NAME");
				int i_cnt = rs.getInt("I_CNT");

				Ingredients ingredients = new Ingredients(i_code, branch_id, i_name, i_cnt);

				list.add(ingredients);

			}
			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public ArrayList<Ingredients> selectAll(String branch_id) {

		Connection con = getConnection();
		ArrayList<Ingredients> list = new ArrayList<>();
		String sql = "select * from INGREDIENTS where BRANCH_ID=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, branch_id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String i_code = rs.getString("I_CODE");
				String branch_Id = rs.getString("BRANCH_ID");
				String i_name = rs.getString("I_NAME");
				int i_cnt = rs.getInt("I_CNT");

				Ingredients ingredients = new Ingredients(i_code, branch_Id, i_name, i_cnt);

				list.add(ingredients);

			}
			rs.close();
			pst.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public static void main(String[] args) {

		IngredientsDAO dao = new IngredientsDAO();

		ArrayList<Ingredients> list = dao.selectAll();

		for (Ingredients ingredients : list) {

			System.out.println(ingredients);

		}

	}

}
