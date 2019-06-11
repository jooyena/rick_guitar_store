import java.sql.*;
import java.util.Queue;

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

	// DB 연결시 필요한 변수
	Connection conn = null;
	PreparedStatement state = null;

	public DB() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/rick_store?serverTimezone=UTC";
			conn = DriverManager.getConnection(url, "root", "125710");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러: " + e);
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

			System.out.println("로드 완료");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Queue<Guitar> Search(GuitarSpec spec) {
		ResultSet result = null;
		Queue<Guitar> temp = null;
		String sql = "SELECT * FROM rick_store WHERE " + "builder IN ('" + spec.getBuilder() + "')" + " AND "
				+ "model IN ('" + spec.getModel() + "')" + " AND " + "type IN ('" + spec.getType() + "')" + " AND "
				+ "numStrings IN ('" + spec.getNumStrings() + "')" + " AND " + "backWood IN ('" + spec.getBackWood()
				+ "')" + " AND " + "topWood IN ('" + spec.getTopWood() + "')";
		// mysql 비교문 GuitarSpec의 matching 과 동일한 함수 잘 동작하면 map 타입으로 변환
		// System.out.println(sql);
		Guitar guitar;
		try {
			result = state.executeQuery(sql);
			while (result.next()) {
				temp.add(new Guitar(result.getString(8), result.getDouble(7),
						new GuitarSpec(toBuilder(result.getString(1)), result.getString(2), toType(result.getString(3)),
								result.getInt(4), toWood(result.getString(5)), toWood(result.getString(6)))));
//
//				result.getString(1);// builder
//				result.getString(2);// model
//				result.getString(3);// type
//				result.getInt(4);// numString
//				result.getString(5);// topWood
//				result.getString(6);// BackWood
//				result.getDouble(7);// price
//				result.getString(8);// serialNumber
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
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

	// 타입변환
	public Wood toWood(String str) {
		switch (str) {
		case "Indian Rosewood":
			return Wood.INDIAN_ROSEWOOD;
		case "Brazilian Rosewood":
			return Wood.BRAZILIAN_ROSEWOOD;
		case "Mahogany":
			return Wood.MAHOGANY;
		case "Maple":
			return Wood.MAPLE;
		case "Cocobolo":
			return Wood.COCOBOLO;
		case "Cedar":
			return Wood.CEDAR;
		case "Adirondack":
			return Wood.ADIRONDACK;
		case "Alder":
			return Wood.ALDER;
		case "Sitka":
			return Wood.SITKA;
		default:
			return null;

		}
	}

	public GType toType(String str) {
		switch (str) {
		case "acoustic":
			return GType.ACOUSTIC;
		case "electric":
			return GType.ELECTRIC;

		default:
			return null;

		}
	}

	public Builder toBuilder(String str) {
		switch (str) {
		case "Fender":
			return Builder.FENDER;
		case "Martin":
			return Builder.MARTIN;
		case "Gibson":
			return Builder.GIBSON;
		case "Collings":
			return Builder.COLLINGS;
		case "Olson":
			return Builder.OLSON;
		case "Ryan":
			return Builder.RYAN;
		case "PRS":
			return Builder.PRS;
		default:
			return null;
		}
	}

}
