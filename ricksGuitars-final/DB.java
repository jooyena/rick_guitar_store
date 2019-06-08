import java.sql.*;

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
			state.setString(5, guitar.spec.getBackWood().toString());
			state.setString(6, guitar.spec.getTopWood().toString());
			System.out.println("로드 완료");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Search(GuitarSpec spec) {
		String sql = "SELECT * FROM rick_store WHERE " + 
				"builder=" + spec.getBuilder() + 
				"AND" + "model=" + spec.getModel()+ 
				"AND" + "type=" + spec.getType() + 
				"AND" +"numStrings=" + spec.getNumStrings()+
				"AND" + "backWood=" +spec.getBackWood()+
				"AND" + "topWood="+spec.getTopWood();
		//mysql 비교문 GuitarSpec의 matching 과 동일한 함수 잘 동작하면 map 타입으로 변환
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
