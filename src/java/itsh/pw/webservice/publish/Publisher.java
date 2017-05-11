package itsh.pw.webservice.publish;

/**
 * 	Clase que Publica las URL del Webservice
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    05/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.endpoints.Ejemplo;
import itsh.pw.webservice.endpoints.Login;
import itsh.pw.webservice.shared.publish.Publishment;
import javax.xml.ws.Endpoint;

public class Publisher {
    public static void main(String[] args) {
        Publishment publishment = new Publishment("localhost", "8080", "WebserviceServer", "http://endpoints.webservice.pw.itsh/");
        
        String ejemploURL = publishment.getPathWsdl("ejemplo");
        String loginURL = publishment.getPathWsdl("login");
        
        Endpoint.publish(ejemploURL, new Ejemplo());
        Endpoint.publish(loginURL, new Login());
    }
}
