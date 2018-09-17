package master;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class connectionfactory {
	Connection cn = null;
	public Connection getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "scott", "tiger");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
