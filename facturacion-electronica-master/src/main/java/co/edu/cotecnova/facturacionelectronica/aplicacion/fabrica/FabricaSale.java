package co.edu.cotecnova.facturacionelectronica.aplicacion.fabrica;

import co.edu.cotecnova.facturacionelectronica.aplicacion.comando.ComandoSale;
import co.edu.cotecnova.facturacionelectronica.dominio.modelo.Sale;
import org.springframework.stereotype.Component;

/**
 * Clase que se encarga de construir una venta dado un comando venta
 * @author Desarrolladores Cotecnova
 * @version 1.0
 * @since 2021
 */

@Component
public class FabricaSale {
    public Sale crear(ComandoSale comandoSale){
        return new Sale(comandoSale.getSaleId(), comandoSale.getClientId(), comandoSale.isActive(), comandoSale.getPurchaseValue(), comandoSale.getCreationDate(), comandoSale.getClient(), comandoSale.getSaleProducts());
    }
}
