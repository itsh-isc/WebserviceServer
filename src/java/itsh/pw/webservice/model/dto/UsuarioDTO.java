package itsh.pw.webservice.model.dto;

/**
 * 	POJO para modelar campos de la Tabla de Base de Datos
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

public class UsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String password;
    private boolean activo;

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", password=" + password + ", activo=" + activo + '}';
    }
}
