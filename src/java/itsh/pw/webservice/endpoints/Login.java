package itsh.pw.webservice.endpoints;

/**
 * 	Clase que implementa el contrato
 *      ILogin
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    05/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.model.dao.UsuarioDAO;
import itsh.pw.webservice.model.dto.UsuarioDTO;
import itsh.pw.webservice.shared.contracts.ILogin;
import itsh.pw.webservice.shared.model.dto.PerfilUsuarioDTO;
import itsh.pw.webservice.utils.Log;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface ="itsh.pw.webservice.shared.contracts.ILogin")
public class Login implements ILogin{

    @Override
    public int validarLogin(String usuario, String password) {
        int result = 0;
        
        UsuarioDAO dao = null;
        UsuarioDTO dto = null;
        
        try{
            dto = new UsuarioDTO();
            dto.setNombre(usuario);
            dto.setPassword(password);

            dao = new UsuarioDAO();
            result = dao.getLogin(dto);
        }catch(Exception e){
            Log.e(e);
        }finally{
            dto = null;
            dao = null;
        }
        
        return result;
    }

    @Override
    public PerfilUsuarioDTO[] getPerfil(int idUsuario) {
        PerfilUsuarioDTO[] result = null;
        
        UsuarioDAO dao = null;
        try{
            dao = new UsuarioDAO();
            List<PerfilUsuarioDTO> list = dao.getPerfil(idUsuario);
            result = list.toArray(new PerfilUsuarioDTO[list.size()]);
        }catch(Exception e){
            Log.e(e);
        }finally{
            dao = null;
        }
        
        return result;
    }
    
}
