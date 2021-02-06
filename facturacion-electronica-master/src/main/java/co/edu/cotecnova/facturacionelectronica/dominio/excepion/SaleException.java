package co.edu.cotecnova.facturacionelectronica.dominio.excepion;

/**
 * Clase que genera una excepcion de venta
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public class SaleException extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public SaleException(String mensaje){
        super(mensaje);
    }
}
