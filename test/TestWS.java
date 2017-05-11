/**
 * 	Clase para pruebas en consola del Webservice
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    05/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.shared.contracts.ContratoWS;
import itsh.pw.webservice.shared.contracts.ILogin;
import itsh.pw.webservice.shared.model.dto.PerfilUsuarioDTO;
import itsh.pw.webservice.shared.publish.Publishment;
import itsh.pw.webservice.utils.Log;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestWS {
    public static void main(String[] args) {       
        TestWS test = new TestWS();
        ILogin contract = (ILogin)test.getContract("login");
        
        int idUsuario = contract.validarLogin("usuario", "secreto");
        Log.m("IdUsuario = " + idUsuario);
        
        PerfilUsuarioDTO[] listDto = contract.getPerfil(idUsuario);
        for(int i = 0; i < listDto.length; i++){
            Log.m(listDto[i].toString());
        }
    }
    
    private ContratoWS getContract(String path){
        ContratoWS resultado = null;
        
        try {
            Publishment publishment = new Publishment("localhost", "8080", "WebserviceServer", "http://endpoints.webservice.pw.itsh/");
            
            URL url = new URL(publishment.getPathWsdl(path));
            
            String serviceURI = publishment.getServiceURI();
            String serviceName = publishment.getServiceName(path);

            QName qname = new QName(serviceURI, serviceName);

            Service service = Service.create(url, qname);
            resultado = service.getPort(ILogin.class);   
        } catch (Exception e) {
            Log.e(e);
        }
        
        return resultado;
    }
}
