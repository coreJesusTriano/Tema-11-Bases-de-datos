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
			    contraseña: banco
			  */
			  conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoJava", "bancoJava", "banco");
			  
			  // muestra información del tipo de sistema de base de datos (MySQL)
			  System.out.println("Base de datos: " + conexion.getMetaData().getDatabaseProductName());

			  // muestra información sobre la versión del sistema de base de datos (5.5.5-10.4.11-MariaDB)
			  System.out.println("Versión: " + conexion.getMetaData().getDatabaseProductVersion());
			  
			  // muestra información del diver MySQL (MySQL Connector/J)
			  System.out.println("Driver: " + conexion.getMetaData().getDriverName());

			  // muestra información de la versión del driver MySQL (mysql-connector-java-8.0.18)
			  System.out.println("Versión del driver: " + conexion.getMetaData().getDriverVersion());

			} catch (SQLException e) {
			  e.printStackTrace();
			} finally {
				try {
				    // libera los resultados
				    if (resultados != null) {
				      resultados.close();
				    }
				    // libera la instrucción
				    if (instruccion != null) {
				      instruccion.close();
				    }
				    // libera la conexión
				    if (conexion != null) {
				      conexion.close();
				    }
				  } catch (Exception e) {
				    e.printStackTrace();
				  }
			}
	} // fin método main()
	
}
