package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.*;

import Connection.Connection;
import javax.faces.bean.ManagedBean;
@ManagedBean
public class Metodos {
	
	private java.sql.Connection connection = null;
	private Statement state = null;
	
	public Metodos() throws ClassNotFoundException {
		Connection conn = null;
		try {
			conn = new Connection("casas_abiertas", "5432", "postgres", "postgres");
			this.connection = conn.connect();
			state = this.connection.createStatement();
		} catch (SQLException e) {
			System.out.println(" ------------- Error de conexi�n SQL: " + e + "--------------------");
		}
	}
	
	
	/* M�todo de lectura */
	
	public ResultSet read(String sql) {
		System.out.println("************* " + sql);
		ResultSet result = null;
		try {
			result = this.state.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("---------------- ERROR METODO READ: " + e + "-----------------");
		}
		return result;
	}
	
	/* M�todo de ejecuci�n */
        
       
	
	public void execute(String sql) {
		try {
			System.out.println("************* " + sql);
			state.execute(sql);
		} catch (SQLException e) {
			System.out.println("---------------- ERROR METODO EXECUTE: " + e + "-----------------");
		}
	}
	
}
