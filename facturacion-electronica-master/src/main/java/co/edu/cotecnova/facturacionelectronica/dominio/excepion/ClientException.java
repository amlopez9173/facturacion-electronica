package co.edu.cotecnova.facturacionelectronica.dominio.excepion;

/**
 * Clase que genera una excepcion de cliente
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public class ClientException extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public ClientException(String mensaje){
        super(mensaje);
    }
}
