package itsh.pw.webservice.endpoints;

/**
 * 	Clase que implementa el contrato
 *      IEjemplo
 * 
 * 	@author     MRYSI. Sinesio Ivan Carrillo Heredia
 * 	@version    05/Abr/2017
 *
**/

/* Modificaciones
 * Fecha		Modificó	Descripción
 * <dd/mm/aaaa>         <autor>		<comentarios>	
 */

import itsh.pw.webservice.shared.contracts.IEjemplo;
import javax.jws.WebService;

@WebService(endpointInterface ="itsh.pw.webservice.shared.contracts.IEjemplo")
public class Ejemplo implements IEjemplo{

    @Override
    public String procesarAlgo(String text1, String text2) {
        String result = "El Webservice recibio del cliente los textos: " + text1 + ", " + text2;
        
        return result;
    }

    @Override
    public boolean procesarOtraCosa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
