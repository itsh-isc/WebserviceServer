package itsh.pw.webservice.model.dao;

/**
 * 	Clase para acceso a los datos la tabla de Base de Datos
 *      Usuario
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    25/Mar/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.model.base.DAO;
import itsh.pw.webservice.model.dto.UsuarioDTO;
import itsh.pw.webservice.shared.model.dto.PerfilUsuarioDTO;
import itsh.pw.webservice.utils.Log;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends DAO{
    public int getLogin(UsuarioDTO dto) {
        int result = 0;
        String databaseTransaction = "{? = call pruebas.validar_credenciales(?,?)}";
        Log.m("\n" + databaseTransaction);
        
        Connection connection = null;
        CallableStatement statement = null;
        
        try {
            connection = super.connectMySQL();
            statement = connection.prepareCall(databaseTransaction);
            
            statement.registerOutParameter(1, Types.INTEGER);
            statement.setString(2, dto.getNombre());       
            statement.setString(3, dto.getPassword());
            statement.execute(); 
            
            result = statement.getInt(1);
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            Log.e(e);
        } finally {
            statement = null;
            connection = null;
        }
        
        Log.m("DAO - getLogin: " + result);
        
        return result;
    }
    
    public List<PerfilUsuarioDTO> getPerfil(int idUsuario){
        List<PerfilUsuarioDTO> result = new ArrayList<PerfilUsuarioDTO>();
        
        String databaseTransaction = "{ call pruebas.qry_perfil(?)}";
        Log.m("\n" + databaseTransaction);
        
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet response = null;
        
        try {
            connection = super.connectMySQL();
            
            statement = connection.prepareCall(databaseTransaction);
            statement.setInt(1, idUsuario);
            statement.execute(); 
            
            response = statement.getResultSet();
            
            PerfilUsuarioDTO dto = null;
            Log.m("Content:");
            while (response.next()) {
                dto = new PerfilUsuarioDTO();
                
                dto.setIdPerfilUsuario(response.getInt(1));
                dto.setIdUsuario(response.getInt(2));
                dto.setNombre(response.getString(3));
                dto.setApellidoP(response.getString(4));
                dto.setApellidoM(response.getString(5));
                dto.setSexo(response.getString(6));
                dto.setMayorDeEdad(response.getInt(7) == 1);
                
                Log.m(dto.toString());
                result.add(dto);
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            Log.e(e);
        } finally {
            statement = null;
            connection = null;
        }
        
        Log.m("DAO - getPerfil: (" + result.size() + " Elements)");
        
        return result;
    }
}
