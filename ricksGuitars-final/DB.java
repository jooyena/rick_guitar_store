import java.sql.*;

import com.sun.javafx.collections.MappingChange.Map;

/*
--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| builder      | varchar(20) | NO   |     | NULL    |       |
| model        | varchar(20) | NO   |     | NULL    |       |
| type         | varchar(20) | NO   |     | NULL    |       |
| numStrings   | varchar(20) | NO   |     | NULL    |       |
| topWood      | varchar(20) | NO   |     | NULL    |       |
| backWood     | varchar(20) | NO   |     | NULL    |       |
| price        | double      | YES  |     | NULL    |       |
| serialnumber | varchar(20) | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
*/
public class DB {
	Guitar guitar;

	// DB ����� �ʿ��� ����
	Connection conn = null;
	PreparedStatement state = null;

	public DB() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/rick_store?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", "125710");

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("����: " + e);
		}
	}

	public void Insert(Guitar guitar) {
		String sql = "INSERT INTO rick_store VALUES(?,?,?,?,?,?,?,?)";
		try {
			state = conn.prepareStatement(sql);
			/* guitar value insert */
			state.setDouble(7, guitar.getPrice());
			state.setString(8, guitar.getSerialNumber());

			/* guitarSpec value insert */
			state.setString(1, guitar.spec.getBuilder().toString());
			state.setString(2, guitar.spec.getModel().toString());
			state.setString(3, guitar.spec.getType().toString());
			state.setInt(4, guitar.spec.getNumStrings());
			state.setString(5, guitar.spec.getTopWood().toString());
			state.setString(6, guitar.spec.getBackWood().toString());

			System.out.println("�ε� �Ϸ�");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Search(GuitarSpec spec) {
		ResultSet result = null;
		String sql = "SELECT * FROM rick_store WHERE " + "builder IN ('" + spec.getBuilder() + "')" + " AND "
				+ "model IN ('" + spec.getModel() + "')" + " AND " + "type IN ('" + spec.getType() + "')" + " AND "
				+ "numStrings IN ('" + spec.getNumStrings() + "')" + " AND " + "backWood IN ('" + spec.getBackWood()
				+ "')" + " AND " + "topWood IN ('" + spec.getTopWood() + "')";
		// mysql �񱳹� GuitarSpec�� matching �� ������ �Լ� �� �����ϸ� map Ÿ������ ��ȯ
		// System.out.println(sql);
		Guitar guitar;
		try {
			result = state.executeQuery(sql);
			while (result.next()) {
				//guitar = new Guitar(result.getString(8),result.getDouble(7),new GuitarSpec(result.getString(1),result.getString(2),result.getString(3),result.getInt(4),result.getString(5),result.getString(6)));
				/*result.getString(1);// builder
				result.getString(2);// model
				result.getString(3);//type
				result.getInt(4);//numString
				result.getString(5);//topWood
				result.getString(6);//BackWood
				result.getDouble(7);//price
				result.getString(8);//serialNumber*/
			}
			//enum Ÿ�� ���� ������...! �׷��� �Ǵ����� �𸣰�����
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void Close() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
