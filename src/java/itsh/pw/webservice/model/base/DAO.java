package itsh.pw.webservice.model.base;

/**
 * 	Superclase para obetos DAO
 *      Usuario
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    30/Mar/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.utils.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class DAO {
    public Connection connectMySQL(){
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            String connectionUrl = "jdbc:mysql://localhost:3306/pruebas";
            String connectionUser = "admin";
            String connectionPassword = "admin";

            connection = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Log.m("New connection to database at " + new Date());
        }catch(Exception e){
            Log.e(e);
        }

        return connection;
    }
}
