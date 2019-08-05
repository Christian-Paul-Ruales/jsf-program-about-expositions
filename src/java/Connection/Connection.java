package Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/** Author **/ 


public class Connection {
	
	private String database = "";
	private String user = "";
	private String password = "";
	private String port = "";
	
	public Connection(String database, String port, String user, String password) {
		this.database = database;
		this.port = port;
		this.user = user;
		this.password = password;
	}
	
	public java.sql.Connection connect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:" + this.port + "/"+ this.database;
		Properties props = new Properties();
		props.setProperty("user", this.user);
		props.setProperty("password", this.password);
		props.setProperty("ssl", "false");
		java.sql.Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, props);
		} catch (Exception e) {
			System.out.println(" ------------- Error de conexión SQL: " + e + "--------------------");
		}
		
		return conn;
	}
	
	
}
