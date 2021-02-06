package co.edu.cotecnova.facturacionelectronica.dominio.excepion;

/**
 * Clase que genera una excepcion de venta producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

public class SaleProductException extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public SaleProductException(String mensaje){
        super(mensaje);
    }
}
