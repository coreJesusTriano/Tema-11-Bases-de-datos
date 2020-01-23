import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		Statement instruccion = null;
		ResultSet resultados = null;
		Connection conexion = null;
		try {
			  /*
			    subprotocolo: mysql
			    host: localhost
			    puerto: 3306
			    base de datos: bancoJava
			    usuario: bancoJava
			    contrase�a: banco
			  */
			  conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoJava", "bancoJava", "banco");
			  
			  // muestra informaci�n del tipo de sistema de base de datos (MySQL)
			  System.out.println("Base de datos: " + conexion.getMetaData().getDatabaseProductName());

			  // muestra informaci�n sobre la versi�n del sistema de base de datos (5.5.5-10.4.11-MariaDB)
			  System.out.println("Versi�n: " + conexion.getMetaData().getDatabaseProductVersion());
			  
			  // muestra informaci�n del diver MySQL (MySQL Connector/J)
			  System.out.println("Driver: " + conexion.getMetaData().getDriverName());

			  // muestra informaci�n de la versi�n del driver MySQL (mysql-connector-java-8.0.18)
			  System.out.println("Versi�n del driver: " + conexion.getMetaData().getDriverVersion());

			} catch (SQLException e) {
			  e.printStackTrace();
			} finally {
				try {
				    // libera los resultados
				    if (resultados != null) {
				      resultados.close();
				    }
				    // libera la instrucci�n
				    if (instruccion != null) {
				      instruccion.close();
				    }
				    // libera la conexi�n
				    if (conexion != null) {
				      conexion.close();
				    }
				  } catch (Exception e) {
				    e.printStackTrace();
				  }
			}
	} // fin m�todo main()
	
}
