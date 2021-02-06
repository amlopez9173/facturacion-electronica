package co.edu.cotecnova.facturacionelectronica.dominio.excepion;

/**
 * Clase que genera una excepcion de producto
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */
public class ProductExcepcion extends RuntimeException{
    private static final Long serialVerionUID = 1L;

    public ProductExcepcion(String mensaje){
        super(mensaje);
    }
}
