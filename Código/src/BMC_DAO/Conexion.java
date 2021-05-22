package BMC_DAO;
import java.sql.*;


public class Conexion {

	private Connection conn = null;
	private String path = "jdbc:mysql://localhost:3306/billermastercontrollerbd?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "password";
	
	
	public Connection conectar() {
		try {		
			conn =  DriverManager.getConnection(path, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return conn;
	}
}